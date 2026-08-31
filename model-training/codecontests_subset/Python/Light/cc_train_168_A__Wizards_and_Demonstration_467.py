# -*- coding: utf-8 -*-
"""
Created on Thu May 27 09:37:05 2021

@author: Vineet
"""

import math
n,x,y=map(int,input().split())
a=math.ceil((y/100)*n )
if a>x:
    b=a-x
    print(b)
else:
    print(0)