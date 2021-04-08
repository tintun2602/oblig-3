const kjøpBilett = (e) => {
    alert("hei"); 
    e.preventDefault(); 

    const kunde = {
        film : $('#film').val(),
        antall : $('#antall').val(), 
        fornavn : $('#fnavn').val(),
        etternavn : $('#enavn').val(),
        telefon : $('#telefonnr').val(), 
        epost : $('#epost').val(),
    };

$.post('/lagre', kunde, function () {
    hentAlle();
});

$('#film').val(""); 
$('#antall').val("");
$('#fnavn').val("");
$('#enavn').val("");
$('#telefonnr').val("");
$('#epost').val(""); 

};

function hentAlle() {
    $.get('/biletter', function(data){
    formaterData(data); 
    });
    
}

const formaterData = (kunder) => {
    melding.innerHTML = ""; 
    for(const kunde of kunder) {
        melding.innerHTML += /*html*/`
        <div>
        Film: ${kunde.film}<br/>
        Antall: ${kunde.antall} <br/>
        Fornavn: ${kunde.fornavn} <br/>
        Etternavn: ${kunde.etternavn} <br/>
        TelefonNr: ${kunde.telefon} <br/>
        Epost: ${kunde.epost}
        </div>
        `;
    }
};

const slettBillet = () => {
    form.reset(); 
    melding.innerHTML = ""; 
    $.get('/slett', function(){
    hentAlle(); 
    });
};
    
    


const melding = document.getElementById('melding'); 
const form = document.querySelector('form'); 
form.addEventListener('submit', kjøpBilett);
form.addEventListener('reset',slettBillet);


