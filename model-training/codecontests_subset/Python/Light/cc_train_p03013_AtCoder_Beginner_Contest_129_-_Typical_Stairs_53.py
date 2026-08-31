n,m = map(int,input().split())
mod = 10**9 + 7
a = [1] * (n+1)
for i in range(m):
    b = int(input())
    a[b] = 0

        
for i in range(2,n+1):
    if a[i] != 0:
        a[i] = a[i-1] + a[i-2]
#print(a)
print(a[n] % mod)
