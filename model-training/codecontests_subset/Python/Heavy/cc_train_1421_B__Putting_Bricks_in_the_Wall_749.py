#dt = {} for i in x: dt[i] = dt.get(i,0)+1
import sys;input = sys.stdin.readline
#import io,os; input = io.BytesIO(os.read(0,os.fstat(0).st_size)).readline #for pypy
inp,ip = lambda :int(input()),lambda :[int(w) for w in input().split()]

#dt = {} for i in x: dt[i] = dt.get(i,0)+1
import sys;input = sys.stdin.readline
#import io,os; input = io.BytesIO(os.read(0,os.fstat(0).st_size)).readline #for pypy
inp,ip = lambda :int(input()),lambda :[int(w) for w in input().split()]

for _ in range(inp()):
    n = inp()
    x = [list(input().strip()) for i in range(n)]
    a,b,c,d = x[0][1],x[1][0],x[n-1][n-2],x[n-2][n-1]
    if a == b == c == d:
        print(2)
        print(1,2)
        print(2,1)
    elif  a == b and c == d:
        print(0)
    elif a == b and c != d:
        print(1)
        if c == a == b:
            print(n,n-1)
        elif d == a == b:
            print(n-1,n)
    elif c == d and a != b:
        print(1)
        if a == c == d:
            print(1,2)
        elif b == c == d:
            print(2,1)
    elif a != b and c != d:
        print(2)
        if b != c:
            print(2,1)
            print(n,n-1)
        else:
            print(1,2)
            print(n,n-1)


