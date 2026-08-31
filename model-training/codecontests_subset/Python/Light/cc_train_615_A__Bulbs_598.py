a, b = map(int, input().split())
s = set()
for i in range(a):
    s = s.union(set([int(x) for x in input().split()][1:]))
if list(s) == list(range(1, b + 1)):
    print("YES")
else:
    print("NO")
