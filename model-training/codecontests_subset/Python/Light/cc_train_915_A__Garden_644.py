n,k=map(int,input().split())
arr=list(map(int,input().split()))
mini=10000
for i in arr:
    if (k%i==0):
        if (k//i<mini):
            mini=k//i

print(mini)
