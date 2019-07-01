function chart(e) {
    return $.cChart(e)
}(function(e) {
    e.cChart = function(t) {
        var n = {
				parent: "", /* parent id */
                type: "Pie", /* Pie | */
                title: null,
				labels: null,
				data: null,
				colors: ["cornflowerblue", "olivedrab", "orange", "tomato", "crimson", "purple", "turquoise", "forestgreen", "navy", "gray"],
				canvasWidth: 200,
				canvasHeight: 200,
				backgroundColor: "#fff",
				legend: true,
				legendPosition: "bottom", /* top | bottom | left | right */
				legendType: "percentage", /* value | percentage */
				legendUnit: "",
                overlay: false,                
                overflowHide: false,                
                onShow: null, /* function */
                onClick: null, /* function */                
                template: '<div class="chart-container"><div class="chart"></div></div>',
                _classes: {
                    box: ".chart-container",
                    closeBtn: ".chart-close-btn",
                    content: ".chart",
					legend: ".chart-legend",
                    overlay: ".chart-overlay"
                }
            },
            t = e.extend({}, n, t),
            r = e(t.template).hide(),
            i = t._classes.box,
            s = {
                init: function() {
                    s._setContent();
                    r.on("click", function(e) {
                        t.onClick != null ? t.onClick(e, r, t) : null
                    })
                },
                _show: function() {
                    var e = function(e) {
                        t.onShow != null ? t.onShow(r, t) : null;
                        if (t.autoHide) {
                            s._hide(true)
                        }
                    };
                    r.fadeIn(250, e)
                },
                _setContent: function() {
					if (t.parent != ""){
						r.appendTo(t.parent);
					}else{
						r.appendTo("body");
					}
					if (t.legend && t.legend != null) {
                        $(t._classes.box).append('<div class="chart-legend"></div>');
                    }
					if (t.legendPosition && t.legendPosition != null) {
                        switch (t.legendPosition) {
                            case "top":
                                $(t._classes.box).css('flex-direction', 'column-reverse');
                                break;
                            case "bottom":
                                $(t._classes.box).css('flex-direction', 'column');
                                break;
                            case "left":
                                $(t._classes.box).css('flex-direction', 'row-reverse');
                                break;
							case "right":
                                $(t._classes.box).css('flex-direction', 'row');
                                break
                        }
                    }
                    if (e.inArray(t.type, ["Pie", "Bar", "Line"]) != -1) {
                        r.addClass(t.type)
                    }
                    if (t.title && t.title != null) {
						r.find(t._classes.content).prepend("<h3>" + t.title + "</h3>");
                    } else {
                        r.addClass("chart-without-title")
                    }
                    if (t.data && t.data != null) {
						if (t.type == "Pie"){
							var listItems = t.data.length,
								canvas = document.createElement('canvas'),
								canvasWidth = t.canvasWidth,
								canvasHeight = t.canvasHeight,
								total = 0,
								totalPercentage = 0,
								pData = [],
								newData = [],
								i = 0,
								startingAngle,
								arcSize,
								endingAngle,
								sData = sum(t.data, t.data.length);
							
							$.each(t.data, function(index, value) {
								newData.push(3.6 * 100 * value / sData);
								pData.push(Math.round(10000 * value / sData) / 100);
							});
    
							function sumTo(a, i) {
								var sum = 0;
								for (var j = 0; j < i; j++) {
									sum += a[j];
								}
								return sum - 90;
							}
							
							function sum(a, i) {
								var sum = 0;
								for (var j = 0; j < i; j++) {
									sum += a[j];
								}
								return sum;
							}
						
							function degreesToRadians(degrees) {
								return ((degrees * Math.PI)/180);
							}
							
							if (t.legend && t.legend != null) {
								var barChart = $('<ul/>', { class: 'bar-chart' });					
								$.each(t.labels, function(index, value) {
									var chartlegend = $('<li/>', { class: 'legend-' + index }),
									legendLabel = $('<span/>', { class: 'label', text: value }),
									percentageValue = pData[index].toString(),
									legendPercentage = $('<span/>', { class: 'percentage', text: (t.legendType == "value") ? t.data[index].toString().replace('.', ',') + ' ' + t.legendUnit : pData[index].toString().replace('.', ',') + '%' }),
									barTrack = $('<span/>', { class: 'bar-track' }),
									bar = $('<span />', { class: 'bar', style: 'width: ' + percentageValue + '%;' + 'background-color: ' + t.colors[index] + '; box-shadow: 0 2px 0 ' + t.colors[index] +';'});
    
									chartlegend.appendTo(barChart);
									legendLabel.appendTo(chartlegend);
									legendPercentage.appendTo(chartlegend);
									barTrack.appendTo(chartlegend);
									bar.appendTo(barTrack);							
								});
								$(t._classes.legend).append(barChart);
							}					
    
							canvas.setAttribute('width', canvasWidth);
							canvas.setAttribute('height', canvasHeight);
							canvas.setAttribute('id', 'chartCanvas');
							r.find(t._classes.content).append(canvas);
  
							var cvs = $("#chartCanvas"),
								ctx = $("#chartCanvas")[0].getContext('2d'),
								centerX = canvasWidth / 2,
								centerY = canvasHeight / 2,
								radius = canvasWidth / 2;
    
							ctx.clearRect(0, 0, canvasWidth, canvasHeight);
							
							$.each(newData, function(index, value) {
								startingAngle = degreesToRadians(sumTo(newData, index));
								arcSize = degreesToRadians(value);
								endingAngle = startingAngle + arcSize;
								ctx.beginPath();
								ctx.moveTo(centerX, centerY);
								ctx.arc(centerX, centerY, radius, startingAngle, endingAngle, false);
								ctx.closePath();
								ctx.fillStyle = t.colors[index];
								ctx.fill();
								ctx.restore();
							});							
    
							ctx.beginPath();
							ctx.moveTo(centerX, centerY);
							ctx.arc(centerX, centerY, radius * .6, 0, 2 * Math.PI, false);
							ctx.closePath();
							ctx.fillStyle = t.backgroundColor;
							ctx.fill();   
						} else 
						if (t.type == "Bar"){
						}						
                    }
                    if (t.overlay && t.overlay != null) {
                        if (e("body").find(t._classes.overlay).length == 0) {
                            e('<div class="chart-overlay' + (typeof t.overlay == "string" ? " " + t.overlay : "") + '"></div>').hide().appendTo("body").fadeIn(250)
                        }
                        r.addClass("chart-overlayed")
                    }					
                    s._show();
                }
            };
        s.init();
        return true
    }
})(jQuery)