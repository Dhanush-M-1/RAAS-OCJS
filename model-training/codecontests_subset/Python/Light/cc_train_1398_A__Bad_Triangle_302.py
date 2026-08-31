from sys import stdin
###############################################################
def iinput(): return int(stdin.readline())
def minput(): return map(int, stdin.readline().split())
def linput(): return list(map(int, stdin.readline().split()))
###############################################################

t = iinput()
while t:
    t-=1
    n = iinput()
    a = linput()
    for i in range(2, n):
        if a[i] >= a[0]+a[1]:
            print(1, 2, i+1)
            break
    else: print(-1)