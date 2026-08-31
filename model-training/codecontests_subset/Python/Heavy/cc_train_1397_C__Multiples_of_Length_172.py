PI = 3.141592653589793238460
INF =  999999999
MOD  = 1000000007
# MOD = 998244353

def add(x,y):
    return (x+y)%MOD

def sub(x,y):
    return (x-y+MOD)%MOD

def mul(x,y):
    return (x*y)%MOD

def gcd(x,y):
    if y == 0:
        return x
    return gcd(y,x%y)

def lcm(x,y):
    return (x*y)//gcd(x,y)

def power(x,y):
    res = 1
    x%=MOD
    while y!=0:
        if y&1 :
            res = mul(res,x)
        y>>=1
        x = mul(x,x)
        
    return res
        
def mod_inv(n):
    return power(n,MOD-2)

def prob(p,q):
    return mul(p,power(q,MOD-2))    
  
def ii():
    return int(input())

def li():
    return [int(i) for i in input().split()]

def ls():
    return [i for i in input().split()]


for t in range(1):

    n = ii()
    a = li()
    if n == 1:
        print(1,1)
        print(-a[0])
        print(1,1)
        print(1)
        print(1,1)
        print(-1)
        continue

    print(1,n)
    ans = []
    for i in range(1,n):
        ans.append(a[i]%(n-1))
    store = [n]
    for i in range(n-1):
        store.append(n*(n-1-ans[i]))
    print(*store)
    print(2,n)
    for i in range(0,n):
        a[i]+=store[i]
        a[i]*=-1
    print(*a[1:])

    print(1,1)
    print((a[0]))
