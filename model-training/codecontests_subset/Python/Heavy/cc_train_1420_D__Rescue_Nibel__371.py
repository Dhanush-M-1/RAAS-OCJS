import io
import os

MOD_NUM = 998244353
cin=io.BytesIO(
    os.read(0,os.fstat(0).st_size)
).readline

FACTORIAL_CACHE = []
INV_FACTORIAL_CACHE = []
MOD_INV_CACHE = {}

def get_input():
    return cin().split()

def get_int_input():
    return map(int, get_input())

def init_factorial_cache(N):
    # 0! = 1! = 1
    globals()['FACTORIAL_CACHE'] = [1] * (N + 1)
    for i in range(2, N + 1):
        FACTORIAL_CACHE[i] = (FACTORIAL_CACHE[i - 1] * i) % MOD_NUM

    globals()['INV_FACTORIAL_CACHE'] = [1] * (N + 1)
    INV_FACTORIAL_CACHE[N] = pow(FACTORIAL_CACHE[N], MOD_NUM - 2, MOD_NUM)
    for i in range(N):
        INV_FACTORIAL_CACHE[N - i - 1] = (INV_FACTORIAL_CACHE[N - i] * (N - i)) % MOD_NUM

def factorial_with_mod(x):
    '''
        Factorial of a number modulo MOD_NUM
    '''
    return FACTORIAL_CACHE[x]

def inv_factorial_with_mod(x):
    '''
        (Inverse of the Factorial of a number) modulo MOD_NUM
    '''
    return INV_FACTORIAL_CACHE[x]

def nCk(n, k):
    '''
        Combinatorial function with modulo MOD_NUM
    '''
    if n < k:
        return 0

    comb = factorial_with_mod(n) * inv_factorial_with_mod(k) * inv_factorial_with_mod(n - k)
    comb %= MOD_NUM

    return comb

def rescue_nibel(N, K, starts, ends):
    ans = 0

    starts.sort()
    ends.sort()

    i = 0
    j = 0
    # Number of bulbs that are currently on
    count_of_on = 0
    while (i < N):
        if (starts[i] < ends[j]):
            count_of_on += 1
            ans += nCk(count_of_on - 1, K - 1)
            ans %= MOD_NUM
            i += 1
        else:
            count_of_on -= 1
            j += 1
    return ans

def main():
    N, K = get_int_input()
    init_factorial_cache(N)
    # List of 2-tuple containing (start, end) time of each bulb
    timings = [0] * N
    starts = [0] * N
    ends = [0] * N
 
    for i in range(N):
        s, e = get_int_input()
        starts[i] = s
        # +1 because the ith bulb is still on at timing[i][1]
        ends[i] = e + 1

    print(rescue_nibel(N, K, starts, ends))

main()
