n, m = [int(i) for i in input().split()]
s = set()
for i in range(n):
    lst = [int(j) for j in input().split()]
    for elem in range(1, lst[0] + 1):
        s.add(lst[elem])
if len(s) != m:
    print("NO")
else:
    print("YES")
