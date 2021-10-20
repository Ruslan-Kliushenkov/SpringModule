<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Sweepstakes</title>
    <link rel="stylesheet" href="/static/style.css">

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <h5>Race</h5>
    <div>
        Race id
        ${race.id}
    </div>
    <div>

        <#list race.horseList as horse>
            <ul class="list-group">
                <#if horse.place == 1>
                    <li class="list-group-item list-group-item-success">Name: ${horse.name}
                        <#if horse.num == race.betOn>
                            <--- BET
                        </#if>
                        </h2>
                    </li>

                    <li class="list-group-item list-group-item-success">
                        Position: ${horse.place}
                    </li>

                <#elseif horse.place == 2>
                    <li class="list-group-item list-group-item-dark">Name: ${horse.name}
                        <#if horse.num == race.betOn>
                            <--- BET
                        </#if>
                        </h2>
                    </li>

                    <li class="list-group-item list-group-item-dark">
                        Position: ${horse.place}
                    </li>

                <#elseif horse.place == 3>
                    <li class="list-group-item list-group-item-warning">Name: ${horse.name}
                        <#if horse.num == race.betOn>
                            <--- BET
                        </#if>
                        </h2>
                    </li>

                    <li class="list-group-item list-group-item-warning">
                        Position: ${horse.place}
                    </li>

                <#else>
                    <li class="list-group-item list-group-item-light">Name: ${horse.name}
                        <#if horse.num == race.betOn>
                            <--- BET
                        </#if>
                        </h2>
                    </li>

                    <li class="list-group-item list-group-item-light">
                        Position: ${horse.place}
                    </li>
                </#if>

            </ul>
        </#list>

    </div>
    <a href="/">home</a>
</div>
</body>
</html>