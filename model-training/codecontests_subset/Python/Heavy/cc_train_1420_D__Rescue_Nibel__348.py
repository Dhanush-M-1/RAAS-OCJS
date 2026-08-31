import io, os
input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

def powerMo(a,n,mo):
    ans = 1
    posi = a
    while n > 0:
        if n&1:
            ans *= posi
            ans %= mo
        n >>= 1
        posi = posi*posi%mo
    return ans

def modInv(a,mo):
    return(powerMo(a,mo-2,mo))


mo = 998244353

def f():
    n, k = [int(s) for s in input().split()]
    comb = [0]*(n+1)
    comb[k] = 1
    for m in range(k+1,n+1):
        comb[m] = (comb[m-1]*(m-1)*modInv(m-k,mo)) %mo

    on = []
    off = []
    for _ in range(n):
        x,y = [int(s) for s in input().split()]
        on.append(x)
        off.append(y)
    on.sort()
    off.sort()

    ans = 0
    count = 0
    i = 0
    j = 0
    while i < n and j<n:
        if on[i] <= off[j]:  # overlap make sense
            i += 1
            count += 1
            ans += comb[count]
        else:
            j += 1
            count -= 1

    print(ans%mo)


f()