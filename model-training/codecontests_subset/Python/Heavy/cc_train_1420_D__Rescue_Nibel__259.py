"""
Accomplished using the EduTools plugin by JetBrains https://plugins.jetbrains.com/plugin/10081-edutools
"""
from collections import Counter
import io,os
input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
if __name__== "__main__":
    # Write your solution here

    def bucketsort(order, seq):
        buckets = [0] * (max(seq) + 1)
        for x in seq:
            buckets[x] += 1
        for i in range(len(buckets) - 1):
            buckets[i + 1] += buckets[i]

        new_order = [-1] * len(seq)
        for i in reversed(order):
            x = seq[i]
            idx = buckets[x] = buckets[x] - 1
            new_order[idx] = i

        return new_order


    def ordersort(order, seq, reverse=False):
        bit = max(seq).bit_length() >> 1
        mask = (1 << bit) - 1
        order = bucketsort(order, [x & mask for x in seq])
        order = bucketsort(order, [x >> bit for x in seq])
        if reverse:
            order.reverse()
        return order


    def long_ordersort(order, seq):
        order = ordersort(order, [int(i & 0x7fffffff) for i in seq])
        return ordersort(order, [int(i >> 31) for i in seq])


    def multikey_ordersort(order, *seqs, sort=ordersort):
        for i in reversed(range(len(seqs))):
            order = sort(order, seqs[i])
        return order


    n,k=map(int, input().split())


    left = []
    right = []

    for _ in range(n):
        l,r = map(int, input().split())
        left.append(l)
        right.append(10)
        left.append(r+1)
        right.append(1)
    temp = multikey_ordersort(range(2 * n), left, right)
    timeline = [(left[i], right[i]) for i in temp]

    # timeline = []
    #
    # for _ in range(n):
    #
    #     l,r = map(int, input().split())
    #     timeline.append((l, 10))
    #     timeline.append((r+1, 1))
    # timeline.sort()





    mod = 998244353
    N = 3 * (10 ** 5 + 1)

    # array to store inverse of 1 to N
    factorialNumInverse = [None] * (N + 1)

    # array to precompute inverse of 1! to N!
    naturalNumInverse = [None] * (N + 1)

    # array to store factorial of
    # first N numbers
    fact = [None] * (N + 1)


    # Function to precompute inverse of numbers
    def InverseofNumber(p):
        naturalNumInverse[0] = naturalNumInverse[1] = 1
        for i in range(2, N + 1, 1):
            naturalNumInverse[i] = (naturalNumInverse[p % i] *
                                    (p - int(p / i)) % p)


    # Function to precompute inverse
    # of factorials
    def InverseofFactorial(p):
        factorialNumInverse[0] = factorialNumInverse[1] = 1

        # precompute inverse of natural numbers
        for i in range(2, N + 1, 1):
            factorialNumInverse[i] = (naturalNumInverse[i] *
                                      factorialNumInverse[i - 1]) % p


    # Function to calculate factorial of 1 to N
    def factorial(p):
        fact[0] = 1

        # precompute factorials
        for i in range(1, N + 1):
            fact[i] = (fact[i - 1] * i) % p


    # Function to return nCr % p in O(1) time
    def Binomial(N, R, p):

        # n C r = n!*inverse(r!)*inverse((n-r)!)
        ans = ((fact[N] * factorialNumInverse[R]) % p *
               factorialNumInverse[N - R]) % p
        return ans


    p = 998244353
    InverseofNumber(p)
    InverseofFactorial(p)
    factorial(p)





    curr = 0
    ans = 0
    for a,b in timeline:
        if b==1:
            curr-=1
        else:
            if curr>=k-1:
                ans+= Binomial(curr, k-1, mod)
            curr+=1


    print(ans%mod)





