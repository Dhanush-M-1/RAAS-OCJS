from itertools import compress, islice, cycle, count

def croft():
    """Yield prime integers using the Croft Spiral sieve.
 
    This is a variant of wheel factorisation modulo 30.
    """
    # Copied from:
    #   https://code.google.com/p/pyprimes/source/browse/src/pyprimes.py
    # Implementation is based on erat3 from here:
    #   http://stackoverflow.com/q/2211990
    # and this website:
    #   http://www.primesdemystified.com/
    # Memory usage increases roughly linearly with the number of primes seen.
    # dict ``roots`` stores an entry x:p for every prime p.
    for p in (2, 3, 5):
        yield p
    roots = {9: 3, 25: 5}  # Map d**2 -> d.
    primeroots = frozenset((1, 7, 11, 13, 17, 19, 23, 29))
    selectors = (1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0)
    for q in compress(
            # Iterate over prime candidates 7, 9, 11, 13, ...
            islice(count(7), 0, None, 2),
            # Mask out those that can't possibly be prime.
            cycle(selectors)
            ):
        # Using dict membership testing instead of pop gives a
        # 5-10% speedup over the first three million primes.
        if q in roots:
            p = roots[q]
            del roots[q]
            x = q + 2*p
            while x in roots or (x % 30) not in primeroots:
                x += 2*p
            roots[x] = p
        else:
            roots[q*q] = q
            yield q
primes = croft
 
def decompose(n):
    for p in primes():
        if p*p > n: break
        if n % p == 0:
            t = 1
            while n % p == 0:
                t *= p
                n //= p
            yield t
    if n > 1:
        yield n
        
def brute(a, b, x, i):
    if i < len(x):
        u = brute(a*x[i], b, x, i+1)
        v = brute(a, b*x[i], x, i+1)
        return u if max(u) < max(v) else v
    else:
        return (a, b)

n = int(input())
print(*brute(1, 1, [v for v in decompose(n)], 0))
