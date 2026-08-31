n = int(input())

evens = []
odds = []
for x in input().split():
    x = int(x)
    if x % 2 == 0:
        evens.append(x)
    else:
        odds.append(x)
evens.sort()
odds.sort()

common = min(len(evens), len(odds))
deletes = 0
if common > 0:
    for x in evens[-common:]:
        deletes += x
    for x in odds[-common:]:
        deletes += x

if len(evens) > common:
    y = evens[-common - 1]
else:
    y = 0
if len(odds) > common:
    z = odds[-common - 1]
else:
    z = 0

print(sum(evens) + sum(odds) - deletes - max(y, z))
