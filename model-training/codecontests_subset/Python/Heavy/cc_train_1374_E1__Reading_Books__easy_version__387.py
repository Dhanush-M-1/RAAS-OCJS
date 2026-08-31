
def answer():
    if(n3+n1 < k):return -1
    if(n3+n2 < k):return -1

    ap=[0]
    for i in range(n1):ap.append(ap[-1] + a[i])
    ap.append(0)

    bp=[0]
    for i in range(n2):bp.append(bp[-1] + b[i])
    bp.append(0)

    start=max(max(0,k-n1),max(0,k-n2))

    s=0
    for i in range(start):s+=common[i]
    common.append(0)

    ans=1e10
    for i in range(start,min(k,n3) + 1):
        ans=min(ans , s + ap[k-i] + bp[k-i])

        s+=common[i]

    return ans
     
    
n,k=map(int,input().split())


a,b,common=[],[],[]
for i in range(n):
    t,x,y=map(int,input().split())
    
    if(x and y):common.append(t)
    elif(x==1 and y==0):a.append(t)
    elif(x==0 and y==1):b.append(t)

common.sort()
a.sort()
b.sort()

n1,n2,n3=len(a),len(b),len(common)

print(answer())
