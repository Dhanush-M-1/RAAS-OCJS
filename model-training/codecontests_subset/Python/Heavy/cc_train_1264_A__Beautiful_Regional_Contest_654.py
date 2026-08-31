import sys
import math
def kek():
    t = int(input())
    for _ in range(t):
        sys.stdin.readline()
        a = list(reversed(sorted(list(map(int, sys.stdin.readline().split())))))
        par = []
        s =  1
        for i in range(1, len(a)):
            if a[i] != a[i-1]:
                par.append(s)
                s = 0
            s += 1
        par.append(s)

        sGold = par[0]
        sumPers = len(a)
        sSilv = 0
        sBronze = 0
        ind = len(par)-1
        for i in range(1, len(par)):
            sSilv += par[i]
            if sSilv > sGold:
                ind = i
                break
        for i in range(ind+1, len(par)):
            sBronze += par[i]
            if sBronze + sSilv + sGold >sumPers//2:
                sBronze -= par[i]
                break
        if sGold >= sSilv or sGold >= sBronze or sBronze == 0 or sGold == 0 or sSilv == 0 or len(par) < 3:
            print(0, 0, 0)
        else:
            print(sGold, sSilv, sBronze)

kek()