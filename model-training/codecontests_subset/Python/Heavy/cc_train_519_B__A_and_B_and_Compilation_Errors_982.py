#KISS
#NO OUTER ALGORITHM

input()
s1 = list(map(int,input().split()))
s2 = list(map(int,input().split()))
s3 = list(map(int,input().split()))
map1 = {}
map2 = {}
map3 = {}
for x in s1:
    if map1.get(x) == None:
        map1[x]=1
    else:
        map1[x] += 1
for x in s2:
    if map2.get(x) == None:
        map2[x] = 1
    else:
        map2[x] += 1
for x in s3:
    if map3.get(x) == None:
        map3[x] = 1
    else:
        map3[x] += 1
m1 = -1
m2 = -1
for i in list(map1.keys()):
    if map2.get(i) == None or map2.get(i) < map1.get(i):
        m1=i
        break
for i in list(map2.keys()):
    if map3.get(i) == None or map3.get(i) < map2.get(i):
        m2=i
        break
print(m1)
print(m2)