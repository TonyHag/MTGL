/**
 * Created by eirikskogland on 26.11.14.
 */

var ID = -1;
var players = new Array();
var rowNum = 0;


function Player(name) {
    this.name = name;
    this.hp = 20;

    ID++;
    this.id = ID;
}

Player.prototype.addHp = function(hp) {
    this.hp+=hp;
}

Player.prototype.removeHp = function(hp) {
    this.hp-=hp;
}



var appendPlayer = function(newPlayer) {

    // Når ID er 0 og 1 vil rownumber være 1, ellers øker den for hver andre spiller
    if(ID % 2 == 0) {
        rowNum++;
    }

    // Legg til UI
    $("#row" + rowNum).append('<div class="col-xs-6 playerInfo"> <div class="row"> <div class="col-xs-12"><p class="playerName">'+ newPlayer.name +'</p></div</div><div class="row"<div class="col-xs-12" ><p class="playerHp" id="hp' + newPlayer.id + '">' + newPlayer.hp + '</p></div></div> ' +
        '<div class="row"> <div class="col-xs-12 text-center"><button class="btn btn-sm btn-primary" id="btn_turn">Turn</button><button class="btn-danger btn-sm subtractHp'+ newPlayer.id +'">-</button> <input type="text" id="changeHP" placeholder="1" value="1"/> <button class="btn-success btn-sm addHp'+ newPlayer.id +'">+</button><button class="btn btn-sm btn-success" id="btn_winner">Declare Winner</button></div></div> </div>');

    // Oppdatering av hp
    var updateHp = function() {
        $("#hp" + newPlayer.id).html(players[newPlayer.id].hp);
    }


    // Legg til funksjonalitet til knapper
    $("button.subtractHp" + newPlayer.id).click(function() {
        players[newPlayer.id].removeHp($("#changeHP").val());
        updateHp();
    });

    $("button.addHp" + newPlayer.id).click(function() {
        var addValue = parseInt($("#changeHP").val());
        players[newPlayer.id].addHp(addValue);
        updateHp();
    });




};




$(function() {

    $("#btn_reset").click(function () {

        var startingHp = $("#startingHp").val();

        var startingHp =  parseInt(startingHp);

        if(isNaN(startingHp)) {
            startingHp = 20;
        }

        for(var i = 0; i < players.length; i++) {
            players[i].hp = startingHp;
            $("#hp" + i).html(players[i].hp);

        }

    });

    $("#btn_newPlayer").click(function() {

        $("#welcomeText").hide();
        var playerName = $("#newPlayerName").val();

        var newPlayer = new Player(playerName);
        players.push(newPlayer);

        appendPlayer(newPlayer);

    });

    setInterval(function() {

    }, 2000);

});

