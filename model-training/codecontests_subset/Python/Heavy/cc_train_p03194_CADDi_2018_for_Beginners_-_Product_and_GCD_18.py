n,p = map(int,input().split())

i = 2
factors = []
factor_sub = set()
if n == 1:
    print(p)
elif p > 1:
    while i * i <= p:
        if p % i:
            i += 1
        else:
            p //=i
            factors.append(i)
            factor_sub.add(i)
    if p > 1:
        factors.append(p)
    if len(factors) < n:
        print('1')
    else:
        ans = 1
        for c in factor_sub:
            temp = factors.count(c)
            while temp >= n:
                ans *= c
                temp -= n
        print(int(ans))
else:
    print('1')