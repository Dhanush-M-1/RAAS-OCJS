import sys
ii = lambda: sys.stdin.readline().strip()
idata = lambda: [int(x) for x in ii().split()]
 
def solve():
    n, m = idata()
    a = idata()
    b = idata()
    slov = {}
    flag  =True
    for i in range(n):
        slov[a[i]] = 0
    for i in range(m):
        slov[b[i]] = 0
    for i in range(n):
        slov[a[i]] += 1
    for i in range(m):
        if slov[b[i]] > 0:
            print('Yes')
            print(1, b[i])
            flag = False
            break
    if flag:
        print('No')
    return

for t in range(int(ii())):
    solve()
