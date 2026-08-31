import sys
n,m=[int(i) for i in input().split(" ")]
c=[0 for i in range(m)]
for i in range(n):
    k=[int(i) for i in input().split(" ")]
    for i in range(k[0]):
        c[k[i+1]-1]+=1
print("YES" if min(c) else "NO")
