t=int(input())
for _ in range(t):
    a,b,c=map(int,input().split())
    s1=0
    s2=0
    m=0
    while(b>=1 and c>=2):
        s1+=3
        b-=1
        c-=2
    if(s1>0 and a>=1 and b>=2):
        while(a>=1 and b>=2):
            s1+=3
            a-=1
            b-=2
    while(a>=1 and b>=2):
        s2+=3
        b-=2
        a-=1
    if(s2>0 and b>=1 and c>=2):
        while(b>=1 and c>=2):
            s2+=3
            b-=1
            c-=2
    
    m=max(s1,s2)
    if(m>0):
        print(m)
    else:
        print("0")