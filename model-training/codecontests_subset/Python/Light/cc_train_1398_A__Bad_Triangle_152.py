import os #4
inp=os.read(0,os.fstat(0).st_size).split(b"\n");_ii=-1
def rdln():
    global _ii
    _ii+=1
    return inp[_ii]
inin=lambda: int(rdln())
inar=lambda: [int(x) for x in rdln().split()]
inst=lambda: rdln().strip().decode()
_T_=inin()
for _t_ in range(_T_):
    n=inin()
    a=inar()
    if a[0]+a[1]>a[n-1]:
        print(-1)
    else:
        print(1,2,n)