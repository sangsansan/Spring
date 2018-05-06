<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<FORM id="CitySelectorForm" action="" method="post">
    <div>
        <label>City Selector:</label>
    </div>
    <INPUT id="CitySelector" type="text" name="CitySelector" size="50" style="width:265px" placeholder="ener the city name"/>
</FORM>
<SCRIPT TYPE="text/javascript">
 $( "#CitySelector" ).autocomplete({
            source: function( request, response ) {
                $.ajax({
                    url: "getcountry",
                    dataType: "json",
                    data:{
                        searchDbInforItem: request.term
                    },
                    success: function( data ) {
                        response( $.map( data, function( item ) {
                            return {
                                country:item.country,
                                
                            }
                        }));
                    }
                });
            },
            minLength: 1,
            select: function( event, ui ) {
                $("#CitySelector").val(ui.item.dbId);
            
            }
        });
 </SCRIPT>

</body>
</html>