a, b = 1, (10**6)
n=int(input())
x=list(map(int,input().split()))

out=min(x[n-1]-a, b-x[0])

for i in range(0, n-1):
    j = max(x[i]-a, b-x[i+1])
    out = min(out, j)

print(out)    
