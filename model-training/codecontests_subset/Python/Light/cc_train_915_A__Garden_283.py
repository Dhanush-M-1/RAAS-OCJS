n, k = [int(i) for i in input().split()]
a = [ int(x) for x in input().split()]
ans = int(1000000)
for i in range(n):
    if k%a[i]==0 and k//a[i] <ans:
        ans=k//a[i]
print(ans)