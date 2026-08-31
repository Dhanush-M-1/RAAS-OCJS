k = list(map(int, input().split()))
m = 0
n = k[0]
while(n!=0):
    m = m+1
    n = n-1
    if m%k[1]==0:
        n=n+1

print(m)
