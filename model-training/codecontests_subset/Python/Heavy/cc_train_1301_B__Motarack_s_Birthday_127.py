# SUBMIT SOURCE # https://gist.github.com/raikuma/6109943d493d3ba825ba995bae70b90c
import sys
from pprint import pprint
if not 'DEBUG' in globals(): readline = sys.stdin.readline
def read(map_func): return map_func(readline().rstrip())
def reads(map_func): return list(map(map_func, readline().rstrip().split()))
def readn(map_func, n): return [map_func(readline().rstrip()) for _ in range(n)]
def readint(): return read(int)
def readints(): return reads(int)
def readcol(n): return readn(int)
def readmat(n): return [readints() for _ in range(n)]
def readmap(n): return readn(list)

def makemat(n, m, v): return [[v for _ in range(m)] for _ in range(n)]
def zeromat(n, m=None): return makemat(n, m if m else n, 0)
def listmat(n, m=None): return [[[] for _ in range(m if m else n)] for _ in range(n)]
def crosslist(y, x, n=None, m=None): return [(p,q) for (p,q) in [(y,x+1),(y-1,x),(y,x-1),(y+1, x)] if (n==None or 0 <= p < n) and (m==None or 0 <= q < m)]
def roundlist(y, x, n=None, m=None): return [(p,q) for (p,q) in [(y,x+1),(y-1,x+1),(y-1,x),(y-1,x-1),(y,x-1),(y+1,x-1),(y+1, x),(y+1,x+1)] if (n==None or 0 <= p < n) and (m==None or 0 <= q < m)]

def plog(obj): pprint(obj) if 'DEBUG' in globals() else None
def log(msg, label=None): print((label+': ' if label else '')+str(msg)) if 'DEBUG' in globals() else None
def _logmat(mat, label=None): fmt='{:'+str(max(max(len(str(s)) for s in m) for m in mat))+'d}'; f=lambda row: '['+' '.join(fmt.format(x) for x in row)+']'; [log('['+f(row),label) if i == 0 else log((' '*(len(label)+3) if label else ' ')+f(row)+']',None) if i == len(mat)-1 else log((' '*(len(label)+3) if label else ' ')+f(row),None) for i, row in enumerate(mat)]
def logmat(mat, label=None): _logmat(mat, label) if 'DEBUG' in globals() else None
# endregion BOJ

# LOGIC HERE #
def solve(A, N):
    B = []
    for i in range(N):
        if A[i] != -1:
            if i == 0:
                if A[i+1] == -1:
                    B.append(A[i])
            elif i == N-1:
                if A[i-1] == -1:
                    B.append(A[i])
            elif A[i-1] == -1 or A[i+1] == -1:
                B.append(A[i])
    # B = [a for a in A if a != -1]
    if not B:
        return 0, 0
    p = max(B)
    q = min(B)
    k = (p + q) // 2
    C = [k if b == -1 else b for b in A]
    m = 0
    for i in range(1, N):
        m = max(abs(C[i]-C[i-1]), m)
    return m, k
for _ in range(readint()):
    N = readint()
    A = readints()
    (m, k) = solve(A, N)
    print(m, k)