a,b= map(int,input().split())
if(b>a):
    print(a)
else:
    count=0
    while(a>0):
        if(a>=b):
            a=a-b+1
            count+=b
        else:
            count+=a
            break
    print(count)
