n,k=map(int, input().split())
a=list(map(int,input().split()))
v=0
for i in range(n):
    if ((k%a[i])==0):
        if(a[i] > v):
            v=a[i]

res=int(k/v)
print(res)


