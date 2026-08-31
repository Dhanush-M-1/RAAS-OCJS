c=input()
a=int (input())
s=0
t=0
for i in range(a):
    x=input()
    if(x==c):
        s=1
        t=1
    else:
        if(x[0]==c[1]):
            s=1
        if(x[1]==c[0]):
            t=1
if( s==t==1):
    print("YES")
else:
    print("NO")