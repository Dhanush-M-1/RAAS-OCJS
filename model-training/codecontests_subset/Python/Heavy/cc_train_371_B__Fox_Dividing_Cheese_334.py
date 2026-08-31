import math
from collections import Counter
def primeFactors(n):
    a = []
    while n % 2 == 0:
        a.append(2)
        n = n // 2
    for i in range(3, int(math.sqrt(n)) + 1, 2):
        while n % i == 0:
            a.append(i)
            n = n // i
    if n > 2:
        a.append(n)
    return a

a,b = list(map(int,input().split()))
hcf = math.gcd(a,b)
if a == b:
    print(0)
else:
    a//=hcf
    b//=hcf
    a = Counter(primeFactors(a))
    b = Counter(primeFactors(b))
    output = 0
    f = 0
    for i in a:
        if i in [2,3,5]:
            output+=a[i]
        else:
            f = 1
            break
    if f==0:
        for i in b:
            if i in [2,3,5]:
                output+=b[i]
            else:
                f = 1
                break
    if f == 1:
        print(-1)
    else:
        print(output)




