import math
from sys import stdin,stdout
def input(): return stdin.readline()
def prin(x): return stdout.write(str(x)+"\n")

t=int(input())
for _ in range(t):
    n=int(input())
    if n==1:
        print(0)
    else:
        two,three=0,0
        while(n%2==0):
            two+=1
            n=n//2
        while(n%3==0):
            three+=1
            n=n//3
        if (n-1)!=0 or two>three:
            print(-1)
        elif three==two:
            print(two)
        else:
            x=two
            print(x+(three-two)*2)