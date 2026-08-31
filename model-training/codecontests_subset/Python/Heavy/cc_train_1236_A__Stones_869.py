n=int(input())
for i in range(n):
    a,b,c=map(int,input().split())
    x=a
    y=b
    z=c
    s1=0
    s2=0
    while(a>=1 and b>=2):
            s1=s1+3
            a=a-1
            b=b-2
    while(c>=2 and b>=1):
            s1=s1+3
            c=c-2
            b=b-1
    a=x
    b=y
    c=z        
    while(c>=2 and b>=1):
            s2=s2+3
            c=c-2
            b=b-1        
    while(a>=1 and b>=2):
            s2=s2+3
            a=a-1
            b=b-2
    if(s1>s2):
        print(s1)
    else:
        print(s2)
           
