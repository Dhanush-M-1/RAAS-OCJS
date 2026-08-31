a,b=map(int,input().split())
L1=[]
for k in range(a):
    L=list(map(int,input().split()))
    for j in range(1,L[0]+1):
        L1.append(L[j])
L1=set(L1)
print(["NO","YES"][len(L1)==b])
