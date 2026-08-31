# written with help of failed tests
def searchBest(iType, number, rType, countResidents):
    global items, equipped
    best = 0
    ret = None
    for item, params in items.items():
        if params[0] == iType:
            val = int(params[number])
            if countResidents:
                for resid in equipped[item]:
                    if resid[1] == rType:
                        val += int(resid[2])
            if val > best:
                best = val
                ret = item
    return ret

def printItem(item):
    global equipped
    print(item, len(equipped[item]), ' '.join([x[0] for x in equipped[item]]))

def searchFor(iType, number, might):
    global items, equipped, liesIn
    pSum = [0]
    for x in might:
        pSum.append(pSum[-1] + int(x[2]))
    while len(pSum) < 11:
        pSum.append(pSum[-1])
    
    bestVal = 0
    for item, params in items.items():
        if params[0] == iType:
            val = int(params[number]) + pSum[int(params[4])]
            if val > bestVal:
                bestVal = val

    for item, params in items.items():
        if params[0] == iType:
            val = int(params[number]) + pSum[int(params[4])]
            if val == bestVal:
                for i in range(min(int(params[4]), len(might))):
                    want = might[i]
                    equipped[liesIn[want[0]]].remove(want)
                    liesIn[want[0]] = item

                    if len(equipped[item]) == int(params[4]):
                        rm = equipped[item][0]
                        liesIn[rm[0]] = want[3]
                        equipped[want[3]] = [rm] + equipped[want[3]]
                        equipped[item].remove(rm)
                    equipped[item].append(want)
                        
                return item


def rel(item):
    global liesIn, equipped, items
    while len(equipped[item]) > int(items[item][4]):
        toDelete = equipped[item][0]
        for other in items:
            if len(equipped[other]) < int(items[other][4]):
                liesIn[toDelete[0]] = other
                equipped[other].append(toDelete)
                break
        equipped[item] = equipped[item][1:]

n = int(input())
items = dict()
equipped = dict()
for i in range(n):
    t = tuple(input().split())
    items[t[0]] = t[1:]
    equipped[t[0]] = []

k = int(input())
residents = [None for i in range(k)]
glads = dict()
liesIn = dict()
for i in range(k):
    residents[i] = tuple(input().split())
    equipped[residents[i][3]] = equipped.get(residents[i][3], []) + [residents[i]]
    liesIn[residents[i][0]] = residents[i][3]

canSwap = False
for name, val in equipped.items():
    if len(val) < int(items[name][4]):
        canSwap = True

if canSwap:
    glads = sorted([x for x in residents if x[1] == 'gladiator'], key = lambda x: -int(x[2]))
    sentries = sorted([x for x in residents if x[1] == 'sentry'], key = lambda x: -int(x[2]))
    phys = sorted([x for x in residents if x[1] == 'physician'], key = lambda x: -int(x[2]))

    wp = searchFor('weapon', 1, glads)
    ar = searchFor('armor', 2, sentries)
    orb = searchFor('orb', 3, phys)
    rel(wp)
    rel(ar)
    rel(orb)
    printItem(wp)
    printItem(ar)
    printItem(orb)
else:
    printItem(searchBest('weapon', 1, 'gladiator', True))
    printItem(searchBest('armor', 2, 'sentry', True))
    printItem(searchBest('orb', 3, 'physician', True))
