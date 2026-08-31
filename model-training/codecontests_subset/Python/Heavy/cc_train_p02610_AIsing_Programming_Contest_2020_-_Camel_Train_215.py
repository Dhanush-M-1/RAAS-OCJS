ma = lambda :map(int,input().split())
ni = lambda:int(input())
import collections
import math
import itertools
import heapq as hq
gcd = math.gcd
t = ni()

def f1(a2):#a2:2次元配列
    a2.sort(key=lambda x:x[1])
    l = len(a2)
    que = []
    ret = 0
    for dif,k in a2:
        if len(que) < k: #k番目までが空いていれば
            ret +=dif
            hq.heappush(que,dif)
        else:
            if que[0] < dif:#差分が得なら
                ret += dif - que[0]
                hq.heappushpop(que,dif)
    return ret
def f2(a2,n):#a2:2次元配列
    a2.sort(key=lambda x:x[1],reverse=True)
    l = len(a2)
    que = []
    ret = 0
    for dif,k in a2:
        if len(que) + k < n: #k+1番目以降が空いていれば
            ret +=dif
            hq.heappush(que,dif)
        else:
            if que and que[0] < dif:#差分が得なら
                ret += dif - que[0]
                hq.heappushpop(que,dif)
    return ret

def solve(n):
    dp = [] ## rが大きい
    dm = [] ## lが大きい
    ans = 0
    for i in range(n):
        k,l,r = ma()
        if r-l >0:#右ぞろえ,rが得
            dp.append((r-l,k))
        else:#左揃え
            dm.append((l-r,k))
        ans +=min(r,l) ##最低値

    #print(ans);print(dp,f2(dp,n));print(dm,f1(dm))
    ans += f2(dp,n) + f1(dm)

    return ans
for i in range(t):
    n = ni()
    print(solve(n))
