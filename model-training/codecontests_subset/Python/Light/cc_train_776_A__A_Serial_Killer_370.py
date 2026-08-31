s= str(input())
ans=s + "\n"
for i in range(int(input())):
    x= str(input())
    y= x.split( )[0]

    if s.split( )[0]==y:
        ans=ans+ x.split( )[1]+ " "
        ans= ans + s.split( )[1]+"\n"
        s= x.split( )[1] + " " + s.split( )[1]
    else:
        ans= ans+ x.split( )[1]+" "
        ans= ans+ s.split( )[0]+"\n"
        s= x.split( )[1]+" "+s.split( )[0]
print(ans.strip())