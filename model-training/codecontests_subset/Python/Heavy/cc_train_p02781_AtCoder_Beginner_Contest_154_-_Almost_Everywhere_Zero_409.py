from math import factorial as f
from functools import reduce
def C(n,k):
    a,b=sorted((k,n-k))
    return reduce(int.__mul__, range(b+1,n+1),1) // f(a)

def almost_everywhere_zero(v, k):
    if not v or not k: return 0
    s = str(v)
    n,d = len(s), int(s[0])
    
    if k>n: return 0
    
    below = 9**k * C(n-1,k) if n>k else 0
    return below + ( d if k==1 else (d-1) * 9**(k-1) * C(n-1,k-1) + almost_everywhere_zero(int(s[1:]), k-1) )
N = input()
K = int(input())
print(almost_everywhere_zero(N,K))