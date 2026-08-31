


from math import log2
from collections import defaultdict

n,k = map(int,input().split())


l = list(map(int,input().split()))

l.sort()
z = l[-1]//2
hash = defaultdict(list)
seti = defaultdict(set)

for i in range(l[-1]+1):
    z = i
    while True:
        seti[i].add(z)
        if z == 0:
            break
        z = z//2

z = l[-1]
for i in range(z+1):

    for j in range(len(l)):
        if l[j]>=i:
            temp = i
            if i == 0:
                i+=1
            ka = log2(l[j]//i)


            if temp in seti[l[j]]:
              if temp == 0:
               ka+=1
               i-=1
              hash[i].append(int(ka))


mini = 10**18
for i in hash:
    hash[i].sort()
    if len(hash[i])>=k:

      mini = min(sum(hash[i][:k]),mini)

print(mini)




