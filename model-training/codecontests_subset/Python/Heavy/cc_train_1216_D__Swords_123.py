import sys
import math
import collections
import bisect
import string
def get_ints(): return map(int, sys.stdin.readline().strip().split())
def get_list(): return list(map(int, sys.stdin.readline().strip().split()))
def get_string(): return sys.stdin.readline().strip()
for t in range(1):
    n=int(input())
    arr=get_list()
    ans=[]
    maxim=max(arr)
    for i in range(n):
        val=maxim-arr[i]
        if val>0:
            ans.append(val)
    if len(ans)==1:
        gcd=ans[0]
    elif len(ans)==2:
        gcd=math.gcd(ans[0],ans[1])
    else:
        gcd=math.gcd(ans[0],ans[1])
        for i in range(2,len(ans)):
            gcd=math.gcd(gcd,ans[i])
    number=sum(ans)//gcd
    print(number,gcd)