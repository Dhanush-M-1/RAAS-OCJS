from sys import stdin
###############################################################
def iinput(): return int(stdin.readline())
def minput(): return map(int, stdin.readline().split())
def linput(): return list(map(int, stdin.readline().split()))
###############################################################


n = iinput()
p1, p2 = 1, 2
ans = 'YES'
while n:
    n-=1
    w = iinput()
    if w == p1:
        p2 = 6 - (p1+p2)
    elif w == p2:
        p1 = 6 - (p1+p2)
    else:
        ans = 'NO'

print(ans)