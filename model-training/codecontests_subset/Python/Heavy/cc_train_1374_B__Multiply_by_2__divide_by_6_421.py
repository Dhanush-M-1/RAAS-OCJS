import random
def mod_mul(a, b, n):
    result = 0
    while b > 0:
        if (b & 1) > 0:
            result = (result + a) % n
        a = (a + a) % n
        b = (b >> 1)
    return result
def mod_exp(a, b, n):
    result = 1
    while b > 0:
        if (b & 1) > 0:
            result = mod_mul(result, a, n)
        a = mod_mul(a, a, n)
        b = (b >> 1)
    return result
def MillerRabinPrimeCheck(n):
    if n in {2, 3, 5, 7, 11}:
        return True
    elif n == 1 or n % 2 == 0 or n % 3 == 0 or n % 5 == 0 or n % 7 == 0 or n % 11 == 0:
        return False
    k, u = 0, n - 1
    while not (u & 1) > 0:
        k += 1
        u = (u >> 1)
    random.seed(0)
    s = 5
    for i in range(s):
        x = random.randint(2, n - 1)
        if x % n == 0:
            continue
        x = mod_exp(x, u, n)
        pre = x
        for j in range(k):
            x = mod_mul(x, x, n)
            if x == 1 and pre != 1 and pre != n - 1:
                return False
            pre = x
        if x != 1:
            return False
        return True






t = int(input())
def sov(n):
    if n==1:
        return 0

    cnt3 = 0
    cnt2 = 0
    while(n%2==0):
        n//=2
        cnt2+=1
    while(n%3==0):
        n//=3
        cnt3+=1
    if n==1:
        if cnt2<=cnt3:
            return cnt3*2-cnt2
        else:
            return -1
    else:
        return -1
for _ in range(t):
    n = int(input())
    print(sov(n))