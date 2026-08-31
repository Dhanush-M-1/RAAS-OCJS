n, m = [int(s) for s in input().split(' ')]
bulbs = set()
for i in range(n):
    for bulb in input().split(' ')[1:]:
        bulbs.add(int(bulb))
if len(bulbs) < m:
    print('NO')
else:
    print('YES')
