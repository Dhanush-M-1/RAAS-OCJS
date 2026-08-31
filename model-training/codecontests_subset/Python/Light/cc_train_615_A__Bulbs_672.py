n,m = map (int,input().split())
a = set()
bulbx = []
c = 0
for i in range(n):
    bulb = [int(x) for x in input().split()]
    bulbx = bulbx + bulb[1:]

for i in range(1,m+1):
    if i in bulbx:
        c = c+i

if c == m*(m+1)/2:
    print("YES")
else:
    print("NO")