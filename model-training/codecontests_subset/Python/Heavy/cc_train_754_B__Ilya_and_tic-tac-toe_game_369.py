T = {}

for i in range(4):
    s = input()
    for (j, c) in enumerate(s):
        if c == 'x':
            T[(i, j)] = 'x'
        elif c == 'o':
            T[(i, j)] = 'o'

def test(T, a):
    e = 0
    oc = 0
    for (i, j) in a:
        if (i, j) in T:
            if T[(i, j)] == 'x':
                oc += 1
        else:
            e += 1
    if e == 1 and oc == 2:
        return True
    else:
        return False


check = [
         [(0, 1), (1,2), (2,3)],
         [(0, 0), (1,1), (2,2)],
         [(1,1), (2,2), (3,3)],
         [(1,0), (2,1), (3,2)],
         [(2,0), (1,1), (0,2)],
         [(3,0), (2,1), (1,2)],
         [(2,1), (1,2), (0,3)],
         [(3,1), (2,2), (1,3)]]
check.extend([[(i, j) for j in range(3)] for i in range(4)])
check.extend([[(i, j)  for j in range(1, 4)] for i in range(4)])
check.extend([[(j, i) for j in range(3)] for i in range(4)])
check.extend([[(j, i)  for j in range(1, 4)] for i in range(4)])

for x in check:
    if test(T, x):
        print('YES')
        break
else:
    print('NO')
