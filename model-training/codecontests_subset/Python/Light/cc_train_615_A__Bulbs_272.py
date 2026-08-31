n,m=map(int,input().split());bulbs=[]
for i in range (n):
    bulb=[int(x) for x in input().split()]
    for k in range (0,bulb[0]):
        bulbs.append(bulb[k+1])
for j in range (0,m):
    if j+1 not in bulbs:
        print("NO")
        break
else:print("YES")
