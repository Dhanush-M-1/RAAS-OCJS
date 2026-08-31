n,m=[int(i) for i in input().split()]
s=set()
for i in range(n):
    for i in [int(i) for i in input().split()][1:]:
        s.add(i)
if len(s)==m:
    print("YES")
else:
    print("NO")