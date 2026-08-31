n=int(input())
a=input()
b=list(map(int,list(str(a))))
import itertools
if 8 not in b or n<11:print(0);exit()
l=b.count(8)
l1=n//11
print(min(l,l1))
