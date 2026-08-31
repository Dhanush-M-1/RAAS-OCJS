import sys
f = sys.stdin
f.readline()
a = [int(x) for x in f.readline().strip().split()]
n = len(a)
a.sort()
left = [0]*(n)
right = [0]*(n)
left[0] = (a[0]-1)
for i in range(1, n):
    left[i] +=  (a[i]-a[i-1])+left[i-1]
right[n-1] = (10**6-a[n-1])
for i in range(n-2, -1, -1):
    right[i] += (a[i+1]-a[i])+right[i+1]

ans = min(left[n-1],right[0])
for i in range(n-1):
    ans = min(ans, max(left[i],right[i+1]))
print(ans)