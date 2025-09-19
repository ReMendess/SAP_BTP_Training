@AbapCatalog.sqlViewName: 'ZD_PRIMEIRA_CDS'
@AbapCatalog.compiler.compareFilter: true
@AbapCatalog.preserveKey: true
@AccessControl.authorizationCheck: #NOT_REQUIRED
@EndUserText.label: 'Primeira CDS View'
@Metadata.ignorePropagatedAnnotations: true
define view ZDD_PRIMEIRA_CDS_VIEW as select from /dmo/airport
{
   
    key airport_id as AirportId,
    name as Name,
    city as City,
    country as Country
    
}
