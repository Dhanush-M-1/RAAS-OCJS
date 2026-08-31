# begin FastIntegerInput;
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
except IndexError:
    pass
if s and s[-1] >= b"0"[0]: inp.append(-num if neg else num)
def fin(size=None):
	global _Index
	if size==None:
		ni=_Index;_Index+=1
		return inp[ni]
	else:
		ni=_Index;_Index+=size
		return inp[ni:ni+size]
# _end_ FastIntegerInput;
# begin PyRivalBootstrap
'''from types import GeneratorType
def recursive(f, stack=[]):
  def wrappedfunc(*args, **kwargs):
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
  return wrappedfunc'''
# _end_ PyRivalBootstrap

t=fin()
for _ in range(t):
    n,m=fin(2)
    a=set(fin(n))
    b=set(fin(m))
    if a.intersection(b):
        print('YES','\n1',list(a.intersection(b))[0])
    else:
        print('NO')