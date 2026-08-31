mod = 10 ** 9 + 7
n,m = map(int,input().split())
l = [1] * (n+1)
for i in range(m):
    a = int(input())
    l[a] = 0
for i in range(2,n+1):
    if l[i] == 0:
        continue
    l[i] = (l[i-2] + l[i-1])%mod
print(l[n])
