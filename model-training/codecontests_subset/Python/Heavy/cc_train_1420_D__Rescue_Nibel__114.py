import os, sys
def inp(): return sys.stdin.buffer.readline().rstrip()
def inpa(): return tuple(map(int, inp().split()))
def out(var): sys.stdout.write(str(var)+"\n")
def outa(var): sys.stdout.write(' '.join(map(str, var))+'\n')

def setup():
    dir_path = os.path.dirname(os.path.realpath(__file__))
    sys.stdin = open(os.path.join(dir_path, "input.txt"), 'r')
    sys.stdout = open(os.path.join(dir_path, "output.txt"), 'w')
#setup()


# mod is prime, lets us use FLT
MAXN = 3 * 10**5
mod = 998244353

# pow(x, e, m) uses binary exponentiation
# have to precompute factorial and inverse factorial because it can be VERY large and slow

# fac has array [0, ..., MAXN]
# invf[i] = (fac[i] ^ (mod-2)) % mod = (i+1) * invf[i+1] % mod

fac = [1]
for i in range(1, MAXN + 1):
    fac.append((fac[-1] * i) % mod)

invf = [pow(fac[-1], mod-2, mod)]
for i in range(MAXN, 0, -1):
    invf.append( (i * invf[-1]) % mod )
invf = invf[::-1]

def C(n,k):
    return (fac[n] * invf[n-k] * invf[k]) % mod if n >= k else 0

def solve(arr, k):
    # on each turn, add or pop based on whether array is even or odd
    ans = cur_total = 0

    for time in arr:
        # lamp i turns on, pick k-1 lamps along with i that are now on
        if time % 2 == 0:
            ans += C(cur_total, k-1) % mod
            cur_total += 1
        # lamp turns off
        else:
            cur_total -= 1

    return ans % mod

# O(nlogn) but a lot less space and overall time compared to heapq
n, k = inpa()
arr = []
for _ in range(n):
    l, r = inpa()
    arr.append(2 * l)
    arr.append(2 * r + 1)
    # if l0 < r0, then 2*l0 < 2*r0+1
    # if l1 > r1, the 2*l1 > 2*r1 + 1
    # if l2 == r2, we add l2 before popping in r2
arr.sort()
out(solve(arr, k))
