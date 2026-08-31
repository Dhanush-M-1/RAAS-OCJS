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

for _ in range(int(input())):
    n=int(input())
    s=input()
    if s[0]=="<" and s[-1]==">":
        co1=co2=0
        for i in range(n):
            if s[i]=="<":
                co1+=1
            else:
                break
        for i in range(1,n+1):
            if s[-i]==">":
                co2+=1
            else:
                break
        print(min(co1,co2))
    else:
        print(0)