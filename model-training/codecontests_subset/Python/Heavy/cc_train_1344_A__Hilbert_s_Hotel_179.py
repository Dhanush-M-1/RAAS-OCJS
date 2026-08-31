import sys
import io, os
import math
gcd = math.gcd
sqrt = math.sqrt
ceil = math.ceil
# arr=list(map(int, input().split()))
input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
def strinp(testcases):
    k = 5
    if (testcases == -1 or testcases == 1):
        k = 1
    f = str(input())
    f = f[2:len(f) - k]
    return f
def main():
    t=int(input())
    for _ in range(t):
        n=int(input())
        arr=list(map(int, input().split()))
        rem=[0]*n
        for i in range(n):
            rem[(i+arr[i])%n]+=1
        trig=False
        for i in range(n):
            if(rem[i]!=1):
                trig=True
                break
        if(trig):
            print("nO")
        else:
            print("yEs")
main()