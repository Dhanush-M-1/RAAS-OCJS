n, m = [int(s) for s in input().split()]
m  = [0]*m
for i in range(n):
    x = [int(s) for s in input().split()][1:]
    for i in x:
        m[i-1] = 1
if sum(m)==len(m):
    print("YES")
else:
    print("NO")
