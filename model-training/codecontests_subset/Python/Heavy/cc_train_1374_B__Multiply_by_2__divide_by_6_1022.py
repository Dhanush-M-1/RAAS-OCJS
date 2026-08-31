import functools
def brute(N):

    @functools.lru_cache(maxsize=N)
    def dfs(n):
        if n == 1:
            return 0
        if n > 6*N:
            return float('inf')
        cands = []
        if n%6 == 0:
            cands.append(1+dfs(n//6))
        cands.append(1+dfs(2*n))
        return min(cands)

    result = dfs(N)
    if result == float('inf'):
        return -1
    return result

def fast1(n):
    # print(n)
    result = float('inf')
    sixpow = 1
    for a in range(32):
        twopow = 1
        for b in range(19):
            # if n == 6**a / 2**b:
            if n == sixpow / twopow:
                print(a,b)
                result = min(result, a+b)
            twopow *= 2
        sixpow *= 6
    if result == float('inf'):
        return -1
    return result

from collections import Counter
def fast(n):
    ctr2 = ctr3 = 0
    while n%2 == 0:
        n//=2
        ctr2+=1
    while n%3 == 0:
        n//=3
        ctr3+=1
    if n != 1:
        return -1
    if ctr2 > ctr3:
        return -1
    return (ctr3 - ctr2) + ctr3

def main():
    t = int(input())
    for _ in range(t):
        n = int(input())
        
        #CHANGE
        # result = brute(n)
        result = fast(n)

        print(result)

def findPatterns():
    for n in range(1, 1000):
        result = brute(n)
        print(n, result)

def randomTest():
    import random
    # for n in range(10**8, 10**9+1):
    t = 10**4
    for i in range(t):
        n = random.randint(1, 10**9)
        b = brute(n)
        f = fast(n)
        print(n, b, f)
        if b != f:
            print('Broken!')
            return
main()
# findPatterns()
# randomTest()