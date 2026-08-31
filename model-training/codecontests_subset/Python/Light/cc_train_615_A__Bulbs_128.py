n, m = map(int, input().split())
lamps = []
for y in range(m):
    lamps.append(y+1)
for i in range(n):
    mylist = list(map(int, input().split()))
    lampsperbutton = mylist[0]
    mylist.pop(0)
    for x in range(lampsperbutton):
        if mylist[x] in lamps:
            lamps.remove(mylist[x])
        else:
            pass
if lamps:
    print("NO")
else:
    print("YES")
