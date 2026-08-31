var dataSetsCount = Number(readline());
for (var i = 0; i < dataSetsCount; i++) {
    var input = readline();
    var possibleMarks = new Array(input.length).fill(0);
    var changesCount = 0;

    for (var j = 1; j < input.length; j++) {
        if (input[j] === input[j - 1] && !possibleMarks[j - 1]) {
            possibleMarks[j] = 1;
        }

        if (j > 1 && input[j] === input[j - 2] && !possibleMarks[j - 2]) {
            possibleMarks[j] = 1;
        }

        changesCount += possibleMarks[j];
    }

    print(changesCount);
}