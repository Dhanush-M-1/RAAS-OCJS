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
n=fin();vals=fin(n)
if n>=2:
    print(1,n)
    ans=[-i*n for i in vals]
    print(*ans)
    print(2,n)
    a1=[i*(n-1) for i in vals[1:n]]
    print(*a1)
    print(1,1)
    print(vals[0]*(n-1))
else:
    #ok
    print(1,1)
    print(-vals[0])
    print(1,1)
    print(0)
    print(1,1)
    print(0)


