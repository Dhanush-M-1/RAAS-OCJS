from collections import Counter
import sys
#n=int(input())
n,k=map(int,input().split())
list=(list(map(int,input().split())))
ans=sys.maxsize
for i in range(0,n):
    if k%list[i]==0:
        if ans>(k/list[i]):
            ans=(k/list[i])
print(int(ans))
