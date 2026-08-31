# n=int(input())
# n,k=map(int,input().split())
# arr=list(map(int,input().split()))
#ls=list(map(int,input().split()))
#for i in range(m):
# for _ in range(int(input())):
#from collections import Counter
#from fractions import Fraction
#s=iter(input())
d=[]
h=[]
t=int(input())
for _ in range(t):
    n, k = map(int, input().split())
    d.append(n)
    h.append(k)
cnt=2
#v=[False]*t
if t<=2:
    print(t)
    exit()

for i in range(1,t-1):
    pre = d[i] - d[i - 1]
    po = d[i + 1] - d[i]
    if pre >h[i]:
        cnt += 1
    elif po>h[i]:
        d[i]=d[i]+h[i]
        cnt += 1
print(cnt)








