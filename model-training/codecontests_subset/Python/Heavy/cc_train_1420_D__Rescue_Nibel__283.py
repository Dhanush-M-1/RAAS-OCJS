import sys
 
def load_sys():
    return sys.stdin.readlines()
 
def load_local():
    with open('input.txt','r') as f:
        input=f.readlines()
    return input

MOD_NUM = 998244353
FACTORIAL_CACHE = []
INV_FACTORIAL_CACHE = []
MOD_INV_CACHE = {}
 
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

def rn(n,k,lamps):
    on = [l[0] for l in lamps]
    off = [l[1] for l in lamps]
    on.sort()
    off.sort()
    prev = ans = 0
    events = []
    i,j = 0,0

    while i<n or j<n:
        if i==n:
            ans += nCk(prev-1, k-1)
            ans %= MOD_NUM
            prev -= 1
            j += 1
            continue
        if on[i] > off[j]:
            ans += nCk(prev-1, k-1)
            ans %= MOD_NUM
            prev -= 1
            j += 1
        else:
            prev += 1
            i += 1
    
    return ans
 
#input=load_local()
input=load_sys()
 
 
lamps=[]
 
for i in range(len(input)):
    input[i] = input[i].split()
    input[i] = [int(x) for x in input[i]]
    if i == 0:
        n,k = input[i]
        init_factorial_cache(n)
    else:
        lamps.append(input[i])
        
 
print(rn(n,k,lamps))