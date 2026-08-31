''' Hey stalker :) '''
INF = 10**10
def main():
    print = out.append
    ''' Cook your dish here! '''
    n = get_int()
    li = get_list()
    for i, ele in enumerate(li):
        if ele<min(i, n-i-1):
            print("No")
            return
    if n%2==0:
        if li[n//2] >= n//2 or li[n//2 - 1]>=n//2:
            print("Yes")
        else: print("No")
        return
    print("Yes")



''' Pythonista fLite 1.1 '''
import sys
from collections import defaultdict, Counter
from bisect import bisect_left, bisect_right
#from functools import reduce
import math
input = iter(sys.stdin.buffer.read().decode().splitlines()).__next__
out = []
get_int = lambda: int(input())
get_list = lambda: list(map(int, input().split()))
#main()
[main() for _ in range(int(input()))]
print(*out, sep='\n')
