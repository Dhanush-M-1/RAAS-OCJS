from bisect import *
from collections import *
from fractions import gcd
from math import factorial
from itertools import *
from heapq import *
import copy

T=int(input())
ABCD=[list(map(int,input().split())) for i in range(T)]
for A,B,C,D in ABCD:
    if B>D or A<B:
        print("No")
    elif C>=B:
        print("Yes")
    else:
        F=D-B
        _gcd=gcd(D,B)
        st=(A-B)%_gcd
        #if A==14 and B==10 and C==8 and D==12:
        #    print(B-C-1)
        if B-_gcd+A%_gcd>C:
            print("No")
        else:
            print("Yes")        
