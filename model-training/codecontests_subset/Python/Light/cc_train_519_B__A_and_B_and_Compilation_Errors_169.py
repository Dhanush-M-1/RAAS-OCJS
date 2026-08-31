from sys import stdin
dic,dic2,size,capt = {},{},[],int(input())
for k in map(int,stdin.readline().split()):
    if k not in dic.keys(): dic.update({k:1})
    else: dic[k]+=1
for j in map(int,stdin.readline().split()):
    if j not in dic2.keys(): dic2.update({j:1})
    else: dic2[j]+=1
    if dic[j] == 1: dic.pop(j)
    else: dic[j]-=1
for x,y in dic.items(): print(x)
for m in map(int,stdin.readline().split()):
    if dic2[m] == 1: dic2.pop(m)
    else: dic2[m]-=1
for x,y in dic2.items(): print(x)

