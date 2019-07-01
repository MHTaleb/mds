SELECT *
FROM   pos_auth.mng_composant_data
WHERE  EXISTS (SELECT 1
               FROM   pos_auth.mng_composant_cmp_datas
               WHERE  mng_composant_cmp_datas.cmp_datas = mng_composant_data.id
                      AND mng_composant_data.id =
                          mng_composant_cmp_datas.cmp_datas
                      AND EXISTS (SELECT 1
                                  FROM   pos_auth.mng_composant
                                  WHERE  mng_composant.cmp_type LIKE
                                         "%application%"
                                         AND mng_composant.id =
mng_composant_cmp_datas.mng_composant_id)); 