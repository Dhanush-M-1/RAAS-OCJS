n, m = map(int, input().split())
x = set()
for _ in range(n):
    x.update(input().split()[1:])

if len(x)==m:
    print("YES")
else:
    print("NO")