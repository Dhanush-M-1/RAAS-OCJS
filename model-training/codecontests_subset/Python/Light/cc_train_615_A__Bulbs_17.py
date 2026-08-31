n, m = [int(x) for x in input().split()]
li = []
for i in range(n):
    l = list(map(int, input().split()))
    l.pop(0)
    for i in l: li.append(i)
li = set(li)
if len(li) == m: print("YES")
else: print("NO")