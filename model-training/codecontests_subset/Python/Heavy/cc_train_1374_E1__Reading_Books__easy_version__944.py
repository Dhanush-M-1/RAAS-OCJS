import sys
input = lambda: sys.stdin.readline().rstrip()
inp = sys.stdin.buffer.readline                                
def I(): return list(map(int,inp().split()))
inf =10**8

n,k=[int(i) for i in input().split()]
al=[] ; bo=[] ; bt=[]
for i in range(n):
    x=[int(i) for i in input().split()]
    if x[1]==1 and x[2]==1:
        bt.append(x[0])
    elif x[1]==0 and x[2]==1:
        bo.append(x[0])
    elif x[1]==1 and x[2]==0:
        al.append(x[0])
al.sort()
bo.sort()
bt.sort()
if len(bt)+len(al)<k or len(bt)+len(bo)<k: 
    print(-1)
    exit(0)
else:
    cnt=[[0,0,0] for i in range(max(len(al),len(bo),len(bt)))]
    for i in range(len(cnt)):
        if i<len(al): cnt[i][0]=al[i]
        else: cnt[i][0]=inf
        if i<len(bo): cnt[i][1]=bo[i]
        else: cnt[i][1]=inf
        if i<len(bt): cnt[i][2]=bt[i]
        else: cnt[i][2]=inf
    cnt.append([inf,inf,2*inf])
    k1=k
    i=0; j=0; k=0 ; val=0 ; ans=0
    while val != k1:
        if cnt[i][0]+cnt[j][1]>=cnt[k][2]:
            ans+=cnt[k][2]
            val+=1
            k+=1
        else:
            ans+=cnt[i][1]+cnt[j][0]
            val+=1
            i+=1
            j+=1
    print(ans)
            
            
            
            
   
            
    

    



    
