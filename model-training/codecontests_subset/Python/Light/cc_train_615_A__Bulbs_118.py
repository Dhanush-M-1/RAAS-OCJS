a, b = map(int,input().split())
every = []
for i in range(a):
    bulb = [int(x) for x in input().split()]
    bulb.remove(bulb[0])
    for i in bulb:
        every.append(i)
outcome = set(every)
if len(outcome) == b:
    print('YES')
else:
    print('NO')