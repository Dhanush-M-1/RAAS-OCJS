n,m=map(int,input().split())
sett=set()
for i in range(m):
    sett.add(i+1)
for j in range(n):
    bulbs=input()
    if " " in bulbs:
        first_space=bulbs.find(" ")
        howmanyconnected=int(bulbs[0:first_space])
        bulbs=bulbs[first_space+1:]
        for k in range(howmanyconnected):
            if " " in bulbs:
                next_space=bulbs.find(" ")
                what_bulb=int(bulbs[0:next_space])
                if what_bulb in sett:
                    sett.remove(what_bulb)
                bulbs=bulbs[next_space+1:]
            else:
                what_bulb=int(bulbs)
                if what_bulb in sett:
                    sett.remove(what_bulb)
if sett==set():
    print ('YES')
else:
    print ('NO')
    
