n,m = map(int, input().split())
on = []
for _ in range(n):
    a = list(map(int, input().split()))
    a=a[1:]
    on = on + a
x = set(on)
if len(x) == m:
    print("YES")
else:
    print("NO")