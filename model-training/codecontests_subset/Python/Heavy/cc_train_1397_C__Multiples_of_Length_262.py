# template -> FastIntegerInput;
import sys
_ord, inp, num, neg, _Index = lambda x: x, [], 0, False, 0
i, s = 0, sys.stdin.buffer.read()
try:
    while True:
        if s[i] >= b"0"[0]:num = 10 * num + _ord(s[i]) - 48
        elif s[i] == b"-"[0]:neg = True
        elif s[i] != b"\r"[0]:
            inp.append(-num if neg else num)
            num, neg = 0, False
        i += 1
except IndexError: pass
if s and s[-1] >= b"0"[0]: inp.append(-num if neg else num)
def fin(size=None):
    global _Index
    if size==None:
        ni=_Index;_Index+=1
        return inp[ni]
    else:
        ni=_Index;_Index+=size
        return inp[ni:ni+size]
'''# template -> PyRivalBootstrap;
from types import GeneratorType
def recursive(f, stack=[]):
  def wrapped(*args, **kwargs):
    if stack: return f(*args, **kwargs)
    else: 
      to = f(*args, **kwargs)
      while True:
        if type(to) is GeneratorType:
          stack.append(to); to = next(to)
        else:
          stack.pop()
          if not stack: break
          to = stack[-1].send(to)
      return to
  return wrapped'''
debug=0
_T_=1
for _t_ in range(_T_):
    n=fin()
    a=fin(n)
    if n==1:
        print(1,1); print(-a[0]); print(1,1); print(0); print(1,1); print(0); break
    print(n,n)
    print(-a[-1])
    a[-1]-=a[-1]
    if debug: print(a)
    print(1,n-1)
    for i in range(n-1):
        print(a[i]*(n-1),end=' ')
        a[i]+=a[i]*(n-1)
    print()
    if debug: print(a)
    print(1,n)
    for i in range(n):
        print(-a[i],end=' ')
        a[i]-=a[i]
    print()
    if debug: print(a)


