import sys 
from collections import defaultdict as dd
from collections import Counter as cc
from queue import Queue
import math
import itertools
try:
    sys.stdin = open('input.txt', 'r') 
    sys.stdout = open('output.txt', 'w')
except:
    pass
input = lambda: sys.stdin.buffer.readline().rstrip()

for _ in range(int(input())):
    k=0
    q=int(input())
    while q%6==0:
        k+=1
        q//=6
    while q%3==0:
        k+=2
        q//=3
    if q==1:
        print(k)
    else:
        print(-1)