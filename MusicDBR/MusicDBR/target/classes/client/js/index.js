function pageLoad() {
    addTable();
    deleteRow();
}

function addTable(){
    $.ajax({
        url: '/track/list',
        type: 'GET',
        success: trackList => {

        let trackHTML = `<div class="container">`
            + `<div class="row mb-2">`
            + `<div class="col-3 bg-light font-weight-bold">Track ID</div>`
            + `<div class="c ol-3 bg-light font-weight-bold">Year</div>`
            + `<div class="col-3 bg-light font-weight-bold">Artist</div>`
            + `<div class="col-3 bg-light font-weight-bold">Track</div>`
            + `</div>`;

    for (let track of trackList) trackHTML += `<div class="row col-form-label">`
        + `<div class="col-3">${track.trackID}</div>`
        + `<div class="col-3">${track.year}</div>`
        + `<div class="col-3">${track.artist}</div>`
        + `<div class="col-3">${track.title}</div>`
        + `</div>`;
            trackHTML += `</div>`;

    $('#trackList').html(trackHTML);
}

});

}

function deleteRow(){
    $(document).on('click', 'button.removebutton', function () { // <-- changes
        alert("aa");
        $(this).closest('tr').remove();
        return false;
    });
}
