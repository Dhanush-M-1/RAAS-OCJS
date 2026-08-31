#!/usr/bin/env python3
import atexit
import io
import sys

_I_B = sys.stdin.read().splitlines()
input = iter(_I_B).__next__
_O_B = io.StringIO()
sys.stdout = _O_B

@atexit.register
def write():
    sys.__stdout__.write(_O_B.getvalue())


def main():
    xh=[]
    n=int(input())
    for _ in range(n):
        xh.append(tuple(map(int,input().split())))
    _=0    
    count=0
    for x,h in xh:
        if _==0:
            lo=x
            count+=1
        elif _==n-1:
            count+=1
            break
        else:
            if x-h>lo:
                lo=x
                count+=1
            else:
                if x+h<xh[_+1][0]:
                    lo=x+h
                    count+=1
                else:
                    lo=x
        _+=1
    print(count)

if __name__=='__main__':
    main()