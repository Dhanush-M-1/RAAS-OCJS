n, m = map(int, input().split())

a=[True]*(n+1)
for i in range(m):
    a[int(input())]=False

r=[0]*(n+1)
r[0]=1

for i in range(1,n+1):
    if not a[i]:
        continue
    r[i]=(r[i-1]+r[i-2])%1000000007

print(r[n])
