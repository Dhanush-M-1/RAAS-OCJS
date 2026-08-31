from functools import lru_cache

N=int(input())
K=int(input())
 
@lru_cache(None)
def F(N, K):
    """N以下で0でないものがちょうどK個。0を含める"""
#     assert N >= 0
    if N < 10:
        if K == 0:
            return 1
        if K == 1:
            return N
        return 0
    q,r = divmod(N,10)
    ret = 0
    if K >= 1:
        # 1の位が nonzero
        ret += F(q, K-1) * r
        ret += F(q-1, K-1) * (9-r)
    # 1の位が zero
    ret += F(q, K)
    return ret
 
# F(100, 1), F(25, 2), F(314159, 2)
 
print(F(N, K))
