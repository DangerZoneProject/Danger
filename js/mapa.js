// var taxiData = [
//     /*Define os pontos de ocorrencia e com o peso de cada tipo de ocorrencia para gerar um mapa de calor de áreas mais perigosas*/
//   {location: new google.maps.LatLng(-7.9969281,-34.8636554), weight:2.0},
//   new google.maps.LatLng(-7.9969281,-34.8636554),

//   {location: new google.maps.LatLng(-7.9971568,-34.8615812), weight:2.0},
//   new google.maps.LatLng(-7.9971568,-34.8615812),

//   {location: new google.maps.LatLng(-7.9908203,-34.8590956), weight:2.0},
//   new google.maps.LatLng(-7.9908203,-34.8590956),
 
//  {location: new google.maps.LatLng(-7.9977949,-34.8633902), weight:2.0},
//   new google.maps.LatLng(-7.9977949,-34.8633902),

//   {location: new google.maps.LatLng(-7.9910753,-34.8563403), weight:2.0},
//   new google.maps.LatLng(-7.9910753,-34.8563403),
  
// ];


    
// Adding 500 Data Points
var map, pointarray, heatmap;

var taxiData = [
    /*Define os pontos de ocorrencia e com o peso de cada tipo de ocorrencia para gerar um mapa de calor de áreas mais perigosas*/
  {location: new google.maps.LatLng(-7.9969281,-34.8636554), weight:10.0},
  new google.maps.LatLng(-7.9969281,-34.8636554),

  {location: new google.maps.LatLng(-7.9979281,-34.8646554), weight:10.0},
  new google.maps.LatLng(-7.9979281,-34.8646554),

  {location: new google.maps.LatLng(-7.9971568,-34.8615812), weight:2.0},
  new google.maps.LatLng(-7.9971568,-34.8615812),

  {location: new google.maps.LatLng(-7.9908203,-34.8590956), weight:2.0},
  new google.maps.LatLng(-7.9908203,-34.8590956),
 
 {location: new google.maps.LatLng(-7.9977949,-34.8633902), weight:2.0},
  new google.maps.LatLng(-7.9977949,-34.8633902),

  {location: new google.maps.LatLng(-7.9910753,-34.8563403), weight:2.0},
  new google.maps.LatLng(-7.9910753,-34.8563403),
  
];

function initialize() {
  var mapOptions = {
    zoom: 16,
    center: new google.maps.LatLng(-7.9950632,-34.8655503),
    mapTypeId: google.maps.MapTypeId.SATELLITE
  };

  map = new google.maps.Map(document.getElementById('map-canvas'),
      mapOptions);

  var pointArray = new google.maps.MVCArray(taxiData);

  heatmap = new google.maps.visualization.HeatmapLayer({
    data: pointArray
  });

  heatmap.setMap(map);
}

function toggleHeatmap() {
  heatmap.setMap(heatmap.getMap() ? null : map);
}

function changeGradient() {
  var gradient = [
    'rgba(0, 255, 255, 0)',
    'rgba(0, 255, 255, 1)',
    'rgba(0, 191, 255, 1)',
    'rgba(0, 127, 255, 1)',
    'rgba(0, 63, 255, 1)',
    'rgba(0, 0, 255, 1)',
    'rgba(0, 0, 223, 1)',
    'rgba(0, 0, 191, 1)',
    'rgba(0, 0, 159, 1)',
    'rgba(0, 0, 127, 1)',
    'rgba(63, 0, 91, 1)',
    'rgba(127, 0, 63, 1)',
    'rgba(191, 0, 31, 1)',
    'rgba(255, 0, 0, 1)'
  ]
  heatmap.set('gradient', heatmap.get('gradient') ? null : gradient);
}

function changeRadius() {
  heatmap.set('radius', heatmap.get('radius') ? null : 20);
}

function changeOpacity() {
  heatmap.set('opacity', heatmap.get('opacity') ? null : 0.2);
}

google.maps.event.addDomListener(window, 'load', initialize);

