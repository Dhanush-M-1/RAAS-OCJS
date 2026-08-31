for i in range(int(input())):
    n=int(input())
    l=list(map(int,input().split()))
    e=[0]*3
    e[0]=1
    t=0
    d=0
    for j in range(1,n):
        if l[j]==l[j-1] :
            e[t]+=1
        elif t==1 and e[1]<=e[0]:
            e[t]+=1
        else:
            t+=1
            if t==2:
                d=j
                break
            e[t]+=1
    r=d
    for j in range(n//2-1,d-1,-1):
        if l[j]==l[j+1]:
            continue
        else:
            r=j
            break
    e[2]=r-d+1
    if e[1]>e[0] and e[2]>e[0] and sum(e)<=n//2:
        print(*e,sep=" ")
    else:
        print(0,0,0)
        
        
        