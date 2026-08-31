n,k=map(int, input().split())
l=list(map(int, input().split()))
l2=[]

for x in l:
    if k%x==0:
        l2.append(x)

print(k//max(l2))

