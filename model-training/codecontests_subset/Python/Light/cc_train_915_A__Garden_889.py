n,k = list(map(int,input().split()))
a = list(map(int,input().split()))
a = sorted(a, reverse=True)
for i in range(n):
    if k%a[i]==0:
        print(k//a[i])
        break
