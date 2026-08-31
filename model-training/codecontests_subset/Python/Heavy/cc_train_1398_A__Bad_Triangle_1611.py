# begin FastIO2
import os
inp=os.read(0,os.fstat(0).st_size).split(b"\n");_ii=-1
def rdln():
    global _ii
    _ii+=1
    return inp[_ii]
inin=lambda typ=int: typ(rdln())
inar=lambda typ=int: [typ(x) for x in rdln().split()]
inst=lambda: rdln().strip().decode()
# end FastIO
# begin DEBUG 
_DEBUG=0
def debug(*args):
    if _DEBUG:
        import inspect
        frame = inspect.currentframe()
        frame = inspect.getouterframes(frame)[1]
        string = inspect.getframeinfo(frame[0]).code_context[0].strip()
        arns = string[string.find('(') + 1:-1].split(',')
        print('.#debug:',end=' ')
        for i,j in zip(arns,args): print(i,' = ',j,end=', ')
        print()
# end DEBUG

_T_=inin()
for _t_ in range(_T_):
    debug(_t_)
    n=inin()
    a=inar()
    if a[0]+a[1]>a[n-1]:
        print(-1)
    else:
        print(1,2,n)