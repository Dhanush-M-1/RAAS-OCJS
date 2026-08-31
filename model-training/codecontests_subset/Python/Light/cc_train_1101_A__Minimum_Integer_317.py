import math
import os
import random
import re
import sys

if __name__ == '__main__':
    t=int(input())
    for i in range(0,t):
        a = list(map(int, input().rstrip().split()))
        l,r,d=a[0],a[1],a[2]
        if(d<l):
            print(d)
        else:
            k=r//d
            #print((k+1))
            t=d*(k+1)
            print(t)
