function main()
{
    var line = readline();
    var arr = line.split(' ');

    //print(arr);

    var c  = parseInt(arr[0]),
        v0 = parseInt(arr[1]),
        v1 = parseInt(arr[2]),
        a  = parseInt(arr[3]),
        l  = parseInt(arr[4]);

    var read = v0,
        days = 1;

    if (c === 0) {
        print(0);
        return 0;
    }
    while (read < c) {
        read += Math.min((v0 - l) + days * a, v1 - l);
        days++;
    }

    print(days);
    return 0;
}
main();