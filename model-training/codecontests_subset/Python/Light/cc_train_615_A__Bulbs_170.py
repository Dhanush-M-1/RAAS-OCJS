import sys

# sys.stdin=open("ivo.in")

n,m = sys.stdin.readline().split()
m = int(m)
d = {i : 0  for i in range(m)}
for i in range(int(n)):
    for s in sys.stdin.readline().split()[1:]:
        b = int(s)
        d[b - 1] = 1
for i in range(m):
    if d[i] == 0:
        print("NO")
        exit(0)

print("YES")
