import math, os, sys
import string, re

from itertools import *
from collections import Counter
from operator import mul

def inputint():
    return int(input())

def inputarray(func=int):
    return map(func, input().split())


n = inputint()

A = list( inputarray() )
B = list( inputarray() )
C = list( inputarray() )

X = Counter(A)
X.subtract(B)

Y = Counter(B)
Y.subtract(C)

print(X.most_common(1)[0][0])
print(Y.most_common(1)[0][0])

