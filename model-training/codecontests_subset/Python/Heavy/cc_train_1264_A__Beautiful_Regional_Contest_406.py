from sys import stdin
from collections import Counter
#####################################################################
def iinput(): return int(stdin.readline())
def sinput(): return input()
def minput(): return map(int, stdin.readline().split())
def linput(): return list(map(int, stdin.readline().split()))
#####################################################################


t = iinput()
while t:
    t -= 1
    n = iinput()
    p = linput()
    if n<5:
        print(0,0,0)
    else:
        medal = [0,0,0] 
        c = Counter(p)
        l = list(c.values())
        medal[0] = l[0]
        j = 1

        while j<len(l) and medal[1] <= medal[0]:
            medal[1] += l[j]
            j+=1

        if sum(medal)<n//2:
            while j<len(l) and (medal[2] <= medal[0] or sum(medal) + l[j] <= n//2):
                medal[2] += l[j]
                j+=1

        if sum(medal)>n//2 or (0 in medal):
            medal = [0,0,0]
        print(*medal)




