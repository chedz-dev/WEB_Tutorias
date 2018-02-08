$(document).ready(function () {
    $('#upload-form').submit(function (event) {
        event.preventDefault();
        var form = $('#upload-form')[0];
        var formData = new FormData(form);
        
        $('#fileStatus').hide();
        $('#queryButtons').html("<button id=\"downloadZip2\" class=\"btn btn-primary\" disabled=\"\">Formatos bancarios</button> <button id=\"downloadXls2\" class=\"btn btn-primary\" disabled=\"\">XLSX</button>");
        $.ajax({
            url: 'UploadFile',
            data: formData,
            type: 'post',
            enctype: 'multipart/form-data',
            cache: false,
            contentType: false,
            processData: false,
            success: function (data) {
                $('#generator').html(data);
                $("[name='alertGenerator']").show(1000);
                $("#continue").prop('disabled', false);
                $('#uploadFileButtons').html("<button id=\"downloadZip2\" class=\"btn btn-primary\" disabled=\"\">Formatos bancarios</button> <button id=\"downloadXls2\" class=\"btn btn-primary\" disabled=\"\">XLSX</button>");
                scroll();
            },
            error: function () {
                alert('Error subiendo el archivo');
            }
        });
    });

    $(document).on("click", "#update", function () {
        updateInfo();
    });
    
    $(document).on("click", "#reprocess", function () {
        $("#myModal").modal();
    });
    
    $(document).on("click", "#process", function () {
        updateInfo();
    });
    
    $("#signinp").click(function () {
        console.log("signin");
        var user = $("#inputEmail").val();
        var password = $("#inputPassword").val(); 
        var dataString = {"user":user, "password":password};
        console.log(dataString);
        $.ajax({
            url: '/Tutorias/LoginServlet',
            data: dataString,
            type: 'post',
            cache: false,
            success: function (data) {
                $('#generator').html(data);
            },
            error: function () {
                alert('error en la consulta');
            }

        });
    });
    //Mecanismo para mostrar loader cuando se llama un servlet
    //a través de AJAX.".
    /*
    $(document).ajaxStart(function () {
        $('#queryButtons').html("<button id=\"downloadZip2\" class=\"btn btn-primary\" disabled=\"\">Formatos bancarios</button> <button id=\"downloadXls2\" class=\"btn btn-primary\" disabled=\"\">XLSX</button>");
        $('#uploadFileButtons').html("<button id=\"downloadZip2\" class=\"btn btn-primary\" disabled=\"\">Formatos bancarios</button> <button id=\"downloadXls2\" class=\"btn btn-primary\" disabled=\"\">XLSX</button>");
        $('body').addClass("loader-modal");
    }).ajaxStop(function () {
        $('body').removeClass("loader-modal");
    });*/
});
function updateInfo() {
    $('#uploadFileButtons').html("<button id=\"downloadZip2\" class=\"btn btn-primary\" disabled=\"\">Formatos bancarios</button> <button id=\"downloadXls2\" class=\"btn btn-primary\" disabled=\"\">XLSX</button>");
    $.ajax({
        url: 'GenerateInfoServlet',
        cache: false,
        success: function (data) {
            $('#generator').html(data);
            $("[name='alertGenerator']").show(1000);
        },
        error: function () {
            alert('error');
        }
    });
}
