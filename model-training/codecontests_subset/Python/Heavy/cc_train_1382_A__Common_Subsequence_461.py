import sys
import math
import bisect
from sys import stdin, stdout
from math import gcd, floor, sqrt, log
from collections import defaultdict
from bisect import bisect_left as bl, bisect_right as br
from collections import Counter

ip = lambda : int(stdin.readline())
inp = lambda: map(int,stdin.readline().split())

t = ip()
for _ in range(t):
    n,m = inp()
    a = list(inp())
    b = list(inp())
    ch = set(a)&set(b)
    if len(ch) == 0:
        print("NO")
    else:
        print("YES")
        ch = list(ch)
        print(1,ch[0])
        

                
            
        

    
        
        
        

        
    
                
        

