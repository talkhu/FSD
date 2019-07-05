document.addEventListener("DOMContentLoaded", function() { initPlayer(); }, false);

var video;
var progressBar;
var muteIcon;

function initPlayer() {
  video = document.getElementById("myVideo"); 
  progressBar = document.getElementById('progress-bar');
  muteIcon = document.getElementById('muteIcon');
}
  
function playVideo() { 
  video.play() 
  $("#play").attr("disabled", true)
  $("#pause").attr("disabled", false)
  $("#stop").attr("disabled", false)
} 

function pauseVideo() { 
  video.pause() 
  $("#play").attr("disabled", false)
  $("#pause").attr("disabled", true)
} 

function stopVideo() { 
  video.pause();
  video.currentTime = 0;
  $("#play").attr("disabled", false)
  $("#stop").attr("disabled", true)
} 

function volumeUpVideo() { 
  if (video.volume <= 1) {  
    video.volume = vid.volume + 0.1
  } 
} 

function volumeDownVideo() { 
  if (vide.volume >= 0) {
    video.volume = vid.volume - 0.1
  }
}   

function volumeMute() { 
  if (video.muted == true) {
    video.muted = false
    muteIcon.setAttribute("class","glyphicon glyphicon-music") 
  } else {
    video.muted = true
    muteIcon.setAttribute("class","glyphicon glyphicon-headphones") 
  }
} 

function clickCounterAdd() {
  var likeNumber = localStorage.getItem('like');
  localStorage.setItem('like', parseInt(likeNumber)+1);
  msgLike.style.color = "RED"
  msgLike.innerText = localStorage.getItem('like');
}

function clickCounterSub() {
  var unLikeNumber = localStorage.getItem('unlike');
  localStorage.setItem('unlike', parseInt(unLikeNumber)+1);
  msgUnLike.style.color = "blue"
  msgUnLike.innerText = localStorage.getItem('unlike');
}

setInterval(function(e){
  var percentage = Math.floor((100 / video.duration) * video.currentTime);
  // Update the progress bar's css width
  progressBar.setAttribute("style", "width: "+percentage + "%;");
  progressBar.setAttribute("aria-valuenow", percentage);
  // Update the progress bar's text (for browsers that don't support the progress element)
  progressBar.innerHTML = percentage + '% played';
});

function loadVideo(src) { 
  video.src=src
}