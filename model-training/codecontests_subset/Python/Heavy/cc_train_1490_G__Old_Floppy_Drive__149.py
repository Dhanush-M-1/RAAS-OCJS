import sys
input=sys.stdin.readline

from bisect import bisect_left
from math import ceil

t=int(input())
for _ in range(t):
    n,m=map(int,input().split())
    a=list(map(int,input().split()))
    x=list(map(int,input().split()))
    max_cycle_sum=-float('inf')
    cycle_sum=0
    pos_max_cycle_sum=[]
    for i in range(n):
        cycle_sum+=a[i]
        max_cycle_sum=max(cycle_sum,max_cycle_sum)
        pos_max_cycle_sum.append(max_cycle_sum)
    for i in range(m):
        if(max_cycle_sum>=x[i]):
            ans=bisect_left(pos_max_cycle_sum,x[i])
            print(ans,end=" ")
            continue
        elif(cycle_sum<=0):
            print(-1,end=" ")
            continue
        else:
            cycles_completed=ceil((x[i]-max_cycle_sum)/cycle_sum)
            ans=n*cycles_completed
            remaining=x[i]-cycles_completed*cycle_sum
            partial=bisect_left(pos_max_cycle_sum,remaining)
            ans+=partial
            print(ans,end=" ")
    print()
        
        
