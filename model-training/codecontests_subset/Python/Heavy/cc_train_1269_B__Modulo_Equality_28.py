''' Hey stalker :) '''
INF = 10**10
def main():
    #print = out.append
    ''' Cook your dish here! '''
    n, m = get_list()
    a = get_list()
    b = get_list()
    cnta = Counter(a)
    cntb = Counter(b)
    keys = list(sorted(cntb.keys()))
    def chk(x):
        for i in keys:
            try:
                if cntb[i]!=cnta[(i-x)%m]: return False
            except : return False
        return True
    key1 = list(sorted(cnta.keys()))[0]
    res = INF
    for ele in keys:
        if cnta[key1]==cntb[ele] and chk(ele-key1):
            res = min(res, (ele-key1)%m)
    print(res)



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
main()
#[main() for _ in range(int(input()))]
print(*out, sep='\n')
