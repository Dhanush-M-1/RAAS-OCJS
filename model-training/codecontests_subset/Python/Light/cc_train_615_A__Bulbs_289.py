import sys
n,m = tuple(map(int, input().split()))

s = [0 for i in range(m)]

for i in range(n):
    x = list(map(int, input().split()))
    for j in range(1, len(x)):
        s[x[j] - 1] = 1
for x in s:
    if x != 1:
        print("NO")
        sys.exit(0)

print("YES")
