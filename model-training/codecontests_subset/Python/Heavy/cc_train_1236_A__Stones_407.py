t=int(input())
for _ in range(t):
    a,b,c=map(int,input().split())
    d,e,f=a,b,c
    m=0
    l=[]
    while(1):
        if(a>=1 and b>=2):
                a=a-1 
                b=b-2 
                m=m+3
        elif(b>=1 and c>=2):
            b=b-1 
            c=c-2 
            m=m+3
        else:
            break 
    l.append(m)
    m=0 
    while(1):
        if(e>=1 and f>=2):
                e=e-1 
                f=f-2 
                m=m+3
        elif(d>=1 and e>=2):
            d=d-1 
            e=e-2 
            m=m+3
        else:
            break
    l.append(m) 
    print(max(l))