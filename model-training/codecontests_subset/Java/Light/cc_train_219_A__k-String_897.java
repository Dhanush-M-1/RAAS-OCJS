function main()
{
    var n = parseInt(readline());
    var str = readline();
    if(str.length % n != 0){print(-1); return;}
    var mas = new Array(26);
    for(var i = 0; i < 26; ++i)
    {
        mas[i] = 0;
    }
    for(var i = 0; i < str.length; ++i)
    {
        mas[str.charCodeAt(i)-97] ++;
    }
    for(var i = 0; i < 26; ++i)
    {
        if(mas[i] != 0 && mas[i] % n != 0){print(-1); return;}
    }
    var new_str = "";
    for(var i = 0; i < n; ++i)
    {
        for(var j = 0; j < 26; ++j)
        {
            if(mas[j] != 0)
            {
                for(var h = mas[j] / n; h > 0; --h)
                {
                    new_str = new_str + String.fromCharCode(j + 97);
                }
            }
        }
    }
    print(new_str);
}
main();