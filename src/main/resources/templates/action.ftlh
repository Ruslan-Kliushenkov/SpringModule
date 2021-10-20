<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sweepstakes</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
${message?if_exists}
<div class="container mt-5">
<h5>Let's begin</h5>
<form action="/start" method="post" xmlns="http://www.w3.org/1999/html">
    <div class="form-group">
        <label class="col-sm-2 col-form-label"> Count of horses : </label>
        <div class="col-sm-6">
            <input type="number" name="horseCount" class="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 col-form-label"> Bet on: </label>
        <div class="col-sm-6">
            <input type="number" name="betOn" class="form-control"/> </div>
    </div>

    <button type="submit" class="btn btn-success">Start!</button>

    <a href="/stats">All races</a>
</form>
</div>
</body>
</html>