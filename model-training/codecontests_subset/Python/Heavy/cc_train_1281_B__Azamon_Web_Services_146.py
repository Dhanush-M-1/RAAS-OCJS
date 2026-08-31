from bisect import bisect_left, bisect_right
def main():
    #print = out.append
    ''' Cook your dish here! '''
    s1, s2 = map(list, input().split())
    sort = list(sorted(list(s1)))
    for i in range(len(s1)):
        if s1[i]>sort[i]:
            res = s1[:]
            for j in range(i, len(s1)):
                new = s1[:]
                new[i], new[j] = new[j], new[i]
                if new<res:
                    res = new
            s1 = res
            break
    print("".join(s1)) if s1<s2 else print("---")


''' Coded with love at Satyam Kumar, India '''
import sys
#from collections import defaultdict, Counter
#from functools import reduce
#import math
#input = iter(sys.stdin.buffer.read().decode().splitlines()).__next__
out = []
get_int = lambda: int(input())
get_list = lambda: list(map(int, input().split()))
#main()
[main() for _ in range(int(input()))]
#print(*out, sep='\n')


