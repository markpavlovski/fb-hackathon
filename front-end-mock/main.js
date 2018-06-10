function loadMap() {
  var latlng = new google.maps.LatLng(51.508742, -122.3321);
  var latlng2 = new google.maps.LatLng(45.5122, -122.6587);

  var myOptions = {
    zoom: 4,
    center: latlng,
    mapTypeId: google.maps.MapTypeId.ROADMAP
  };

  var map = new google.maps.Map(document.getElementById("map_container"), myOptions);

  var marker = new google.maps.Marker({
    position: latlng,
    map: map,
    title: "my hometown, Malim Nawar!"
  });

  var marker2 = new google.maps.Marker({
    position: latlng2,
    map: map,
    title: "my hometown, Malim Nawar!"
  });

}
