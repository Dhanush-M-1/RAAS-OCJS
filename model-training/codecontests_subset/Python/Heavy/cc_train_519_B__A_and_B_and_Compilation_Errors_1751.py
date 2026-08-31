n = int(input())
dict1 = dict()
dict2 = dict()
dict3 = dict()
res1 = 0
res2 = 0
s = input().split()
for i in s:
    i = int(i)
    if i not in dict1:
        dict1[i] = 1
    else:
        dict1[i] += 1
#print(dict1)
s = input().split()
for i in s:
    i = int(i)
    if i not in dict2:
        dict2[i] = 1
    else:
        dict2[i] += 1
    dict1[i] -= 1
    if dict1[i] == 0:
        del dict1[i]
for i in dict1:
    res1 = i
s = input().split()
for i in s:
    i = int(i)
    if i not in dict3:
        dict3[i] = 1
    else:
        dict3[i] += 1
    dict2[i] -= 1
    if dict2[i] == 0:
        del dict2[i]
for i in dict2:
    res2 = i
print(res1)
print(res2)