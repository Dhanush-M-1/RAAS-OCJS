from sys import stdin
inp = lambda : stdin.readline().strip()

t = int(inp())

for _ in range(t):
    n, m = [int(x) for x in inp().split()]
    a = [int(x) for x in inp().split()]
    b = [int(x) for x in inp().split()]
    elemA = [0]*1001
    elemB = [0]*1001
    for i in a:
        elemA[i] += 1
    for i in b:
        elemB[i] += 1
    for i in range(1001):
        if elemA[i] > 0 and elemB[i] > 0:
            print('YES')
            print(1, i)
            break
    else:
        print('NO')