import sys
from collections import defaultdict
# input=sys.stdin.readline

for _ in range(int(input())):
    n=int(input())
    lis=list(map(int,input().split()))
    if lis[0]+lis[1]<=lis[-1]:
        print(1,2,n)
    else:
        print(-1)

# for i in range(int(input())):
#     s=input()
#     l=[]
#     c=0
#     for i in s:
#         if i=="1":
#             c+=1
#         else:
#             if c!=0:
#                 l.append(c)
#                 c=0
#     if c!=0:
#         l.append(c)
#     l.sort(reverse=True)
#     print(sum(l[::2]))

