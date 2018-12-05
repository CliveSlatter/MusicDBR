function pageLoad() {

    $.ajax({
        url: '/track/list',
        type: 'GET',
        success: trackList => {

            let trackHTML = `<table>` +
                `<tr>` +
                `<th>Track No</th>` +
                `<th>Year</th>` +
                `<th>Artist</th>` +
                '<th>Track Title</th>' +
                `</tr>`;
            for (let track of trackList)
                trackHTML += `<tr>` +
                    `<td>${track.id}</td>` +
                    `<td>${track.year}</td>` +
                    `<td>${track.artist}</td>` +
                    `<td>${track.title}</td>` +
                    `</tr>`;
            trackHTML+=`</table>`;
            $('#trackList').html(trackHTML);
        }

    });
}