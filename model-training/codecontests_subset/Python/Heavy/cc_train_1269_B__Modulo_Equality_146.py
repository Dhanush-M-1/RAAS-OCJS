import sys
from collections import Counter
n,m = list(map(int,input().split()))
a = list(map(int,input().split()))
b = list(map(int,input().split()))
a1 = Counter(a)
b1 = Counter(b)
a1k = sorted(list(a1.keys()))
b1k = sorted(list(b1.keys()))
a1n = len(a1)
b1n = len(b1)
f = 0
# print(a1k,a1)
# print(b1k,b1)
out = sys.maxsize
for i in range(a1n):
    s = 0
    for j in range(i,i+a1n):
        if b1[b1k[j%a1n]]==a1[a1k[j-i]]:
            if (j-i)>0 and (b1k[j%a1n]-b1k[(j-1)%a1n])%m==(a1k[j-i]-a1k[j-i-1]):
                s+=1
            elif (j-i)==0:
                s+=1
            else:
                break
        else:
            break
        # print(b1k[j%a1n],a1k[j-i],b1[b1k[j%a1n]],a1[a1k[j-i]],s,j-i)
    if s==a1n:
        out = min(out,(b1k[i]-a1k[0])%m)
print(out)