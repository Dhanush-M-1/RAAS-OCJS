n,k=map(int,input().split())
a=[int(i) for i in input().split()]
mx=100000
for i in a:
    if k%i==0:
        mx=min(mx,k//i)
print(mx)