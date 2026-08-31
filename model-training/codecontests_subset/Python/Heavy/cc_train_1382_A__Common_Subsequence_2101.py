from collections import defaultdict,Counter
from math import ceil

#n,k = map(int,input().split())
#a = sorted(list(map(int,input().split())))
#a = list(map(int,input().split()))
alph = "abcdefghijklmnopqrstuvwxyz"
t = int(input())
for _ in range(t):
    #n = int(input())
    n,m = map(int,input().split())
    a = set(map(int,input().split()))
    b = set(map(int,input().split()))
    i = a.intersection(b)
    if not i:
        print ("NO")
    else:
        print("YES")
        print (1, list(i)[0])


    