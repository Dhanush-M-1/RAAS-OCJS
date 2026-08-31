import random

def isPrime(n):
	
	
    if n!=int(n):
        return False
    n=int(n)
    
    if n==0 or n==1 or n==4 or n==6 or n==8 or n==9:
        return False

    if n==2 or n==3 or n==5 or n==7:
        return True
    s = 0
    d = n-1
    while d%2==0:
        d>>=1
        s+=1
    assert(2**s * d == n-1)

    def trial_composite(a):
        if pow(a, d, n) == 1:
            return False
        for i in range(s):
            if pow(a, 2**i * d, n) == n-1:
                return False
        return True

    for i in range(20):#number of trials
        a = random.randrange(2, n)
        if trial_composite(a):
            return False

    return True

def gcd(x, y):
    return x if y == 0 else gcd(y, x % y)

n = int(input())

divs = [n]

def split(parts):
    global divs
    divs = [gcd(d, p) for d in divs for p in parts if gcd(d, p) != 1]

while not all([isPrime(x) for x in divs]):
    x = random.randint(0, n - 1)
    g = gcd(n, x)
    if gcd(n, x) != 1:
        split([g, n // g])
        continue
    y = int(input('sqrt {}\n'.format(x * x % n)))
    if x == y:
        continue
    a, b = abs(x - y), x + y
    g = gcd(x, y)
    split([a // g, b // g, g])

print('!', len(divs), ' '.join(str(d) for d in sorted(divs)))