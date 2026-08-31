n, m = map(int, input().split())
s = set()
for i in range(n):
    x, *l = map(int, input().split())
    for y in l:
        s.add(y)
if len(s) == m:
    print("YES")
else:
    print("NO")


