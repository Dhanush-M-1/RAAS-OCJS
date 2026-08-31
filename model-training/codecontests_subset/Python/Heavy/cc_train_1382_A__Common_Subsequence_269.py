# import sys
# from collections import defaultdict

# ONLINE_JUDGE = not __debug__
# if not ONLINE_JUDGE:
#     sys.stdin=open('input.txt', 'r')
# 	# sys.stdout=open('output.txt','w')

import sys
from os import path
if(path.exists('input.txt')):
    sys.stdin = open("input.txt","r")
    # sys.stdout = open("output.txt","w")

input=sys.stdin.readline
 
t = int(input())
for _ in range(t):
    n, m = map(int, input().split())
    a = set(map(int, input().split()))
    b = set(map(int, input().split()))
    c = a.intersection(b)
    if c:
        print("YES")
        print("1 {}".format(c.pop()))
    else:
        print("NO")
