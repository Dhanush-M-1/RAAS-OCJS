n=+readline()
kek=3
res="YES"
while(n--)
{
    x=+readline()
    if (x==kek)
    {
        res="NO"
    }
    else
    {
        kek=6-kek-x
    }
}
print(res)
