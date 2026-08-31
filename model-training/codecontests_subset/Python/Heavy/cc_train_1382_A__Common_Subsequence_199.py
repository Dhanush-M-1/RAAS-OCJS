from sys import stdin
###############################################################
def iinput(): return int(stdin.readline())
def minput(): return map(int, stdin.readline().split())
def linput(): return list(map(int, stdin.readline().split()))
###############################################################

t = iinput()
while t:
    t-=1
    n, m = minput()
    a = linput()
    b = linput()
    for i in range(n):
        if a[i] in b:
            print('YES')
            print(1, a[i])
            break
    else:
        print('NO')