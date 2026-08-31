
n, m = tuple(map(int, input().split(" ")))

s = set()

for _ in range(n):
    l = [int(v) for v in input().split(" ")][1:]
    s = s.union(set(l))

if set(range(1, m+1)) == s:
    print("YES")
else:
    print("NO")


