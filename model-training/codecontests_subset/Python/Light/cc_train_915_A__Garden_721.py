n,k=map(int, input().split())
a=[int(a) for a in input().split()]
res=[]
i=int()
for i in range(len(a)):
    if k%a[i]==0:
        res.append(k/a[i])
print(int(min(res)))