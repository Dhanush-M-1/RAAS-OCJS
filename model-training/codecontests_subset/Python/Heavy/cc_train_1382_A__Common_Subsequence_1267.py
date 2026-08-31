from sys import stdin
input = lambda: stdin.readline().rstrip("\r\n")
from collections import deque as que, defaultdict as vector
from heapq import*
inin = lambda: int(input())
inar = lambda: list(map(int,input().split()))
'''from types import GeneratorType
def bootstrap(f, stack=[]):
    def wrappedfunc(*args, **kwargs):
        if stack: return f(*args, **kwargs)
        else:
            to = f(*args, **kwargs)
            while True:
                if type(to) is GeneratorType:
                    stack.append(to)
                    to = next(to)
                else:
                    stack.pop()
                    if not stack: break
                    to = stack[-1].send(to)
            return to
    return wrappedfunc'''


Testcase=inin()
for _ in range(Testcase):
    n,m=inar()
    a=set(inar())
    b=set(inar())
    x=a.intersection(b)
    x=list(x)
    if x==[]:
        print('NO')
    else:
        print('YES')
        print(1,x[0])