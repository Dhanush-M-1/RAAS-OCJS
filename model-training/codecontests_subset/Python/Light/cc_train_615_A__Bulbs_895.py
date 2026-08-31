n,m=[int(x) for x in input().split()]
bulbs=[]
for i in range (n):
    bulb=[int(x) for x in input().split()]
    for j in range(1,len(bulb)):
        bulbs.append(bulb[j])
k=set(bulbs)
if len(k)==m:
    print('YES')
else:
    print('NO')