n, m = [int(item) for item in input().split()]
u = [0] * (m + 1)
u[0] = 1
for i in range(n):
    l = [int(item) for item in input().split()][1:]
    for k in l:
        u[k] = 1

for i in range(m + 1):
    if u[i] == 0:
        print("NO")
        break
else:
    print("YES")