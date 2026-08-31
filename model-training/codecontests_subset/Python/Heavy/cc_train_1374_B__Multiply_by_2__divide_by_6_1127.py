#!/bin/python3

import math
import os
import random
import re
import sys
from collections import defaultdict



case = int(input())

for i in range(case):
    # a = [int(x) for x in  input().split() ]
    # x,y, n = a[0], a[1], a[2]
    inp = int(input())
    if inp == 1:
        print(0)
    elif  inp%3 !=0 :
        print(-1)
    else:
        cnt2, cnt3 = 0, 0
        flg = True
        while inp !=1:
            if inp % 2 ==0:
                inp/= 2
                cnt2+=1
            elif inp % 3  == 0:
                inp /= 3
                cnt3+=1
            else:
                flg = False
                break
        if cnt2 > cnt3 or flg is False:
            print(-1)
        else:
            # print(inp, '---', cnt2, ' ', cnt3)
            print(cnt3 + (cnt3 -cnt2))