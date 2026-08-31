# -*- coding: utf-8 -*-
# @Date    : 2020-01-11 07:14:43
# @Author  : Anuj Puri (anujpuri72@gmail.com)
# @Link    : link
# @Version : 1.0.0
 
import sys
sys.setrecursionlimit(10**5+1)
 
inf     =  int(10 ** 20)
max_val =  inf
min_val = -inf
 
RW  = lambda : sys.stdin.readline().strip()
RI  = lambda : int(RW())
RMI = lambda : [int(x) for x in sys.stdin.readline().strip().split()]
RWI = lambda : [x for x in sys.stdin.readline().strip().split()]
n = RI()
l=RMI()
hun=l.count(100)
two=l.count(200)
# print(hun,two)
if(n%2==0):
    if ((hun%2 ==0) and (two%2==0)):
        print("YES")
    else:
        print("NO")
else:
    if( abs((2*two)-hun) % 2 ==0 and (hun!=0)):
        print("YES")
    else:
        print("NO")