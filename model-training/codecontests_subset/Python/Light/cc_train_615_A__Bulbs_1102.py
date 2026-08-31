n,m = map (int,input().split())
a = set()
bulbx = []
b = 0
for i in range(n):
    bulb = [int(x) for x in input().split()]
    bulbx = bulbx + bulb[1:]

for i in range(1,m+1):
    if i in bulbx:
        b = b+i

if b == m*(m+1)/2:
    print("YES")
else:
    print("NO")