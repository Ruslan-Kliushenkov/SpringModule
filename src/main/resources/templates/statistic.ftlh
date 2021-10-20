<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Getting Started: Serving Web Content</title>
    <link rel="stylesheet" href="/static/style.css">

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <h5> All races </h5>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Date</th>
            <th scope="col">Details</th>
        </tr>
        </thead>
        <tbody>
        <#list raceList as race>
            <tr>
                <td>${race.id}</td>
                <#--<td><#list race.horseList as horse>${horse.name}(${horse.place})<#sep>, </#list></td>
                <td>${race.betOn}</td>-->
                <td>${race.date}</td>
                <td>
                    <form method="get" action="/race" class="form-inline">
                        <input type="hidden" name="id" value="${race.id}" class="form-control" placeholder="id"/>
                        <#if race.won>
                            <button type="submit" class="btn btn-success btn-sm">Win</button>
                        <#else>
                            <button type="submit" class="btn btn-danger btn-sm">Lose</button>
                        </#if>
                    </form>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
    <a href="/">home</a>
</div>
</body>
</html>