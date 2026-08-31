# -*- coding: utf-8 -*-
"""
Created on Sun Jun 28 21:15:15 2020

@author: jyotm
"""


#import sys
#import numpy as np
line = input()

#arr = np.array(input().rstrip()).astype(int)
for c in range(1,int(line)+1):
    no = int(input())
    #arr = list(map(int, input().split()))
    #k = arr[0]*(arr[2]//arr[0])+ arr[1]
    
    ind = 0
    flg = True
    while(no != 1):
        if no% 3 != 0:
            print(-1)
            flg = False
            break;
        else:
            if no%6 == 0:
                no/=6
            else:
                no*=2
            ind+=1
    if flg:
        print(ind)
    #print('newssfaf')