#n=int(input())
'''
from itertools import accumulate
from bisect import bisect_left

n,m=list(map(int,input().split()))
aa=[0]+list(map(int,input().split()))
bb=list(map(int,input().split()))

aa=list(accumulate(aa))

ans=list()
for b in bb:
    house=bisect_left(aa,b)
    appart=b-aa[house-1]
    ans.append(f'{house} {appart}')
print('\n'.join(ans))
'''

n=int(input())
p=list(map(int,input().split()))

l1=list(range(1,n,2))
l2=list(range(2,n+1,2))

p=sorted(p)
l1=sorted(l1)
l2=sorted(l2)

s1=sum([abs(a-b) for a,b in zip(p,l1)])
s2=sum([abs(a-b) for a,b in zip(p,l2)])
print(min(s1,s2))
