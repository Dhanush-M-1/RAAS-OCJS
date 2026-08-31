from collections import *

N=int(input())
S=Counter([input() for _ in range(N)])
a=["AC","WA","TLE","RE"]
[print(x+" x "+str(S[x])) for x in a]
