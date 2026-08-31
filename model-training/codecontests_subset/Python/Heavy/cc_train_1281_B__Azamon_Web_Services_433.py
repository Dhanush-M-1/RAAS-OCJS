import sys


# inf = open('input.txt', 'r')
# reader = (line.rstrip() for line in inf)
reader = (line.rstrip() for line in sys.stdin)

t = int(next(reader))
for _ in range(t):
    a, b = next(reader).split()
    cs = [(c, i) for i, c in enumerate(a)]
    cs.sort()
    j = None
    for i in range(len(a)):
        if a[i] != cs[i][0]:
            c = cs[i][0]
            for j in range(len(a) - 1, i, -1):
                if a[j] == c:
                    break
            break
    if j is None:
        newA = a
    else:
        newA = list(a)
        newA[i], newA[j] = newA[j], newA[i]
        newA = ''.join(newA)
    if newA < b:
        print(newA)
    else:
        print('---')
    
# inf.close()
