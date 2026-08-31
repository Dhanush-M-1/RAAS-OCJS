from math import sqrt

def primes(n):
    primfac = []
    boundry = int(sqrt(n)) + 1
    d = 2
    while d <= boundry:
        if (n % d) == 0:
            primfac.append(d)
        d += 1
    if n > 1:
        if n not in primfac:
            primfac.append(n)
    return primfac

def freq_factor():
    l, r = input().split()
    l = int(l)
    r = int(r)
    freqs = {}
    for v in range(l, r + 1):
        for f in primes(v):
            try:
                freqs[f] += 1
            except:
                freqs[f] = 1
    print(max(freqs.items(), key=lambda x:x[1])[0])
if __name__=="__main__":
    l, r = input().split()
    l = int(l)
    r = int(r)
    if l == r:
        print(l)
    else:
        print(2)
