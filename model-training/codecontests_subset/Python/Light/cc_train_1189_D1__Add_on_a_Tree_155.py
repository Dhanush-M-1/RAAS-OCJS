from collections import Counter
from sys import stdin
n=int(input())
lst=[]
for _ in range(n-1):
    a,b=map(int,stdin.readline().split())
    lst.append(a)
    lst.append(b)
fg=0
for _,i in Counter(lst).items():
    if i==2:
        fg=1
        break
if fg==1:
    print("NO")
else:
    print("YES")