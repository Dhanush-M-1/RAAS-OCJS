import sys
import math
import collections
import bisect
import string
def get_ints(): return map(int, sys.stdin.readline().strip().split())
def get_list(): return list(map(int, sys.stdin.readline().strip().split()))
def get_string(): return sys.stdin.readline().strip()
for t in range(int(input())):
    n,m=get_ints()
    s=list(get_string())
    pos=get_list()
    lower=string.ascii_lowercase
    counter=dict()
    for i in lower:
        counter[i]=0
    pos.sort()
    index=dict()
    for i in range(n):
        if s[i] in index:
            index[s[i]].append(i+1)
        else:
            index[s[i]]=[i+1]
    #print(pos)
    for i in index:
        row=index[i]
        #print(i,row)
        for j in row:
            index_of_alpha=j
            val=m-bisect.bisect_left(pos,index_of_alpha)
            #print(j,val)
            counter[i]+=val
    for j in s:
        counter[j]+=1
    print(*counter.values())