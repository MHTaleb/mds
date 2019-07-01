function populateForm($form, data) {
    console.log("PopulateForm, All form data: " + JSON.stringify(data));
    $.each(data, function(key, value) // all json fields ordered by name
            {
                console.log("Data Element: " + key + " value: " + value);
                var $ctrls = $form.find('[name=' + key + ']'); //all form elements for a name. Multiple checkboxes can have the same name, but different values
                console.log("Number found elements: " + $ctrls.length);
                if (value !== null && typeof value === 'object') {
                    populateForm($form, value);
                } else {

                    if ($ctrls.is('select')) //special form types
                    {
                        $('option', $ctrls).each(function() {
                            if (this.value == value)
                                this.selected = true;
                        });
                    } else if ($ctrls.is('textarea')) {
                        $ctrls.val(value);
                    } else {
                        switch ($ctrls.attr("type")) //input type
                        {
                            case "text":
                            case "hidden":
                            case "email":
                            case "tel":
                                $ctrls.val(value);
                                break;
                            case "radio":
                                if ($ctrls.length >= 1) {
                                    console.log("Radio $ctrls.length: " + $ctrls.length + " value: " + value);
                                    $.each($ctrls, function(index) { // every individual element
                                        var elemValue = $(this).attr("value");
                                        if (elemValue == value) {
                                            $(this).prop('checked', true);
                                        } else {
                                            $(this).prop('checked', false);
                                        }
                                    });
                                }
                                break;
                            case "checkbox":
                                if ($ctrls.length > 1) {
                                    console.log("CheckBox $ctrls.length: " + $ctrls + " value.length: " + value);
                                    $.each($ctrls, function(index) // every individual element
                                        {
                                            var elemValue = $(this).attr("value");
                                            var elemValueInData = undefined;
                                            var singleVal;
                                            for (var i = 0; i < value.length; i++) {
                                                singleVal = value[i];
                                                console.log("singleVal : " + singleVal + " value[i][1]" + value[i][1]);
                                                if (singleVal === elemValue) {
                                                    elemValueInData = singleVal
                                                };
                                            }
                                            if (elemValueInData) {
                                                console.log("TRUE elemValue: " + elemValue + " value: " + value);
                                                $(this).prop('checked', true);
                                                //$(this).prop('value', true);
                                            } else {
                                                console.log("FALSE elemValue: " + elemValue + " value: " + value);
                                                $(this).prop('checked', false);
                                                //$(this).prop('value', false);
                                            }
                                        });
                                } else if ($ctrls.length == 1) {
                                    $ctrl = $ctrls;
                                    if (value) {
                                        $ctrl.prop('checked', true);
                                    } else {
                                        $ctrl.prop('checked', false);
                                    }
                                }
                                break;
                        } //switch input type
                    }
                }
            }) // all json fields
} // populate form