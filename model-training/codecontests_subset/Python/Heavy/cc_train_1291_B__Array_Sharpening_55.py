ll=lambda:map(int,input().split())
t=lambda:int(input())
ss=lambda:input()
lx=lambda x:map(int,input().split(x))
from math import log10 ,log2,ceil,factorial as fac,gcd
#from itertools import combinations_with_replacement as cs 
#from functools import reduce
#from bisect import bisect_right as br,bisect_left as bl
#from collections import Counter
#from math import inf


 


for _ in range(t()):
#def f():
    
    
    n=t()
    l=list(ll())

    a,b=-1,n

    for i in range(n):
        if l[i]<i:
            break
        a=i

    for i in range(n-1,-1,-1):
        if l[i]<(n-i-1):
            break
        b=i
    if a>=b:
        print("yes")
    else:
        print("no")
        

    
    
    

    

    
    
    
#f()

'''
50 5 5 5 10 40

5 5 5 
          
'''
