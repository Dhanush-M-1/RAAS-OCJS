ll=lambda:map(int,input().split())
t=lambda:int(input())
ss=lambda:input()
lx=lambda x:map(int,input().split(x))
yy=lambda:print("YES")
nn=lambda:print("NO")
from math import log10 ,log2,ceil,factorial as fac,gcd,inf
#from itertools import combinations_with_replacement as cs 
#from functools import reduce
#from bisect import bisect_right as br,bisect_left as bl
#from collections import Counter
#from math import inf


        
for _ in range(t()):
#def f():
    
    a,b=inf,0
    for i in range(t()):
        n,m=ll()

        a=min(a,m)
        b=max(b,n)

    print(b-a if (b-a)>0 else 0)

    
#f()

'''


 
'''
