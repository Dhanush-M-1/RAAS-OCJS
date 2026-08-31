import sys

s, l = map(int, input().split())
alllights = set([])
for i in range(s):
    bulbs = [int(j) for j in input().split()]
    bulbs.pop(0)
    alllights.update(bulbs)

if(len(alllights) == l):
    print('YES')
else:
    print('NO')