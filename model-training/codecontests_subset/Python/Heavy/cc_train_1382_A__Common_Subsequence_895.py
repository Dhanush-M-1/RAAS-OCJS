n=int(input())
for i in range(0,n):
    a,b=map(int,input().split())
    l=list(map(int,input().split()))
    l1=list(map(int,input().split()))
    a-=1
    b-=1
    l.sort()
    l1.sort()
    p=set(l)
    q=set(l1)
    c=min(a,b)
    f=0
    if c==a:
        for j in p:
            if j in q:
                output=j
                f=1
                break
    else:
        for j in q:
            if j in p:
                output=j
                f=1
                break
    if(f==1):
        print("YES")
        print(f'{1} {output}')
    else:
        print("NO")
            
            
    