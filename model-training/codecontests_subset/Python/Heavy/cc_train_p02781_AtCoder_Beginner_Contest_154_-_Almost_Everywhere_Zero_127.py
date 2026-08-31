#maspyさんのやつ

from functools import lru_cache

n = int(input())
k = int(input())

@lru_cache(None)
def f(n, k):
    assert n >= 0 #例外処理
    if n < 10:
        if k == 0:
            return 1 #0しかない数 = 0
        elif k == 1:
            return n #k = 1ならn個分存在している
        return 0 #k >= 2のときは、0を返す
    
    q, r = divmod(n, 10)
    res = 0
    
    if k >= 1:
        #1の位が0でないとき
        res += f(q, k-1) * r
        res += f(q-1, k-1) * (9 - r)
    #１の位が0
    res += f(q, k)
    return res

print(f(n, k))