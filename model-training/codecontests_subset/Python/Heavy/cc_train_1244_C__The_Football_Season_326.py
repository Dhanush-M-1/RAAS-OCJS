
import sys, bisect, heapq, math
sys.setrecursionlimit(10**9+7)
def fi(): return int(sys.stdin.readline())
def fi2(): return map(int, sys.stdin.readline().split())
def fi3(): return sys.stdin.readline().rstrip()
def fo(*args):
    for s in args: sys.stdout.write(str(s)+' ')
    sys.stdout.write('\n')
##    sys.stdout.flush()
def puts(*args):
    for s in args: sys.stdout.write(str(s))
OUT = []
def bfo(*args):
    for s in args: OUT.append(str(s)+' ')
    OUT.append(' ')
def bputs(*args):
    for s in args: OUT.append(str(s))        
def flush():
    sto = ''.join(OUT); fo(sto)
##
alpha = 'abcdefghijklmnopqrstuvwxyz'; mod = 10**9+7; inf = int(2e18+5) ; nax = 101010
##

def gcdExtended(a, b):  
    if a == 0 :  
        x = 0
        y = 1
        return (x, y)
          
    x1, y1 = gcdExtended(b%a, a) 
  
    x = y1 - (b//a) * x1 
    y = x1 
  
    return (x, y)


n, p, w, d = fi2()

g = math.gcd(w, d)
x, y = gcdExtended(w, d)

ww = w//g
dd = d//g

if p%g != 0:
    print(-1)
    exit()

x = x*p//g
y = y*p//g

assert(w*x + y*d == p)

if y < 0:
    k = abs(y)//ww + 5
    y += ww*k
    x -= dd*k

k = y//ww
y -= ww*k
x += dd*k

assert(w*x + y*d == p)

z = n - x - y

if x >= 0 and y >= 0 and z >= 0:
    print(x, y, z)
else:
    print(-1)



