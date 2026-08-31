a,b=map(int,input().split())
if(b>a):
    print (a)
else:
    s=a
    while True:
        k=a//b
        r=a%b
        s=s+k
        a=r+k
        if(a<b):
            break
    print (s)
