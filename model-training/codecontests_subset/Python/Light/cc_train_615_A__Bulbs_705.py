n, m = (int(i) for i in input().split())
bulbs =  set()
for i in range(n):
    l = [int(s) for s in input().split()]
    for j in l[1:]:
        bulbs.add(j)
print("YES" if len(bulbs) == m else "NO")