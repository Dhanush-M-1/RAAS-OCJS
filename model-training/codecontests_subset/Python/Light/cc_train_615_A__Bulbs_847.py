n, m = map(int, input().split())


x = set()

for i in range(n):
    t = list(map(int,input().split()))[1:]
    x= x.union(set(t))
if len(x) == m:
    print("YES")
else:
    print("NO")