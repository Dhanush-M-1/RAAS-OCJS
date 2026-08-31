from sys import stdin as Si
from math import floor as F 
from collections import defaultdict as dt
from operator import itemgetter as ig
from math import pi 


if __name__== '__main__':
    N,k = map(int,Si.readline().split())
    Id  = list(map(int,Si.readline().split()))
    p = 0
    if k==1:        print(Id[0])
    elif 1<k<=3:    print(Id[:2][k%2])
    elif 3<k<=6:    print(Id[:3][k%3-1])
    else:
        n,p,lp=4,6,4
        while p<k:
            lp=p
            p = int(n*(n+1)/2)
            n+=1
        print(Id[:n][k-lp-1])
