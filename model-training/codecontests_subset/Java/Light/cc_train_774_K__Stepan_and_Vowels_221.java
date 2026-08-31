var n = +readline();
var s = readline();

var res = "", len = 0;
for(var i = 0; i < s.length; i++)
{
    if (i - 1 >= 0 && s[i - 1] == s[i] && 
        (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u' || s[i] == 'y'))
        {
            if ((i + 1 == s.length || s[i + 1] != s[i]) && len == 0 && (s[i] == 'e' || s[i] == 'o'))
                res = res + s[i];
            len++;
        }
        else
        {
         res = res + s[i];
         len = 0;
        }
}

print(res);