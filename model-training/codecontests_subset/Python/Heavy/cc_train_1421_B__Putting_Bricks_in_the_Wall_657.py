import sys
INP = lambda: sys.stdin.readline().strip()
INT = lambda: int(INP())
MAP = lambda: map(int, INP().split())
ARR = lambda: [ord(i)-48 for i in list(INP())]
def JOIN(arr, x=' '): return x.join([str(i) for i in arr])
def EXIT(x='NO'): print(x); exit()

for _ in range(INT()):
    n = INT()
    arr = [INP() for _ in range(n)]
    a12,a21 = int(arr[0][1]),int(arr[1][0])
    anm,amn = int(arr[-1][-2]),int(arr[-2][-1])
    del arr
    if a12==a21:
        if anm==amn:
            if a12==anm:
                print(2)
                print(1,2)
                print(2,1)
            else:
                print(0)
        else:
            if a12==anm:
                print(1)
                print(n,n-1)
            else:
                print(1)
                print(n-1,n)
    else:
        if anm==amn:
            if a12==anm:
                print(1)
                print(1,2)
            else:
                print(1)
                print(2,1)
        else:
            if a12==anm:
                print(2)
                print(2,1)
                print(n,n-1)
            else:
                print(2)
                print(1,2)
                print(n,n-1) 