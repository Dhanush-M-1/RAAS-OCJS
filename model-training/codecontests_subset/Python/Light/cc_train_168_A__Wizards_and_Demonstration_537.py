__author__ = 'Esfandiar'
import sys
from math import ceil
input = sys.stdin.readline
n,x,y = map(int,input().split())
Person = ceil(n*(y/100))
print(max(0,Person-x))
