# import sys,os,io
# input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

PI = 3.141592653589793238460
INF =  float('inf')
MOD  = 1000000007
# MOD = 998244353


def bin32(num):
    return '{0:032b}'.format(num)

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

for t in range(ii()):
    t+=1
    input()
    k,n,m = li()
    a = li()
    b  = li()

    ans = []
    x = 0
    y = 0
    flag = 1
    while x < n or y < m:
        if x<n and y < m:
            if a[x] == 0:
                ans.append(0)
                x+=1
                k+=1
            elif b[y] == 0:
                ans.append(0)
                y+=1
                k+=1
            else:
                if a[x] < b[y] :
                    if a[x] <= k:
                        ans.append(a[x])
                    else:
                        flag = 0
                        break
                    x+=1
                else:
                    if b[y] <= k:
                        ans.append(b[y])
                    else:
                        flag = 0
                        break
                    y+=1
        else:
            if x== n:
                if b[y] <= k:
                    ans.append(b[y])
                    if b[y] == 0:
                        k+=1
                else:
                    flag = 0
                    break
                y+=1
            else:
                if a[x] <= k:
                    ans.append(a[x])
                    if a[x] == 0:
                        k+=1
                else:
                    flag = 0
                    break
                x+=1
    if flag:
        print(*ans)
    else:
        print(-1)



                
                