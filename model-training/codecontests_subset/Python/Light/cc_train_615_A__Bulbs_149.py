def poss():
    n,m=map(int,input().split())
    a=[0]*m
    am=0
    for i in range(n):
        b=list(map(int,input().split()))
        for i in range(1,b[0]+1):
            if a[b[i]-1]==0:
                a[b[i]-1]=1
                am+=1
                if am==m:
                    return "YES"
    return "NO"

print(poss())


            
