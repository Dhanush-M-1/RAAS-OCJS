n = int(input())
arr = list(map(int,input().split()))
arr1 = list(map(int,input().split()))
arr2 = list(map(int,input().split()))
d = {}
for i in range(len(arr)):
    if arr[i] not in d.keys() :
        d[arr[i]] = 1
    else :
        d[arr[i]] +=1
c = {}
for i in range(len(arr1)) :
    d[arr1[i]] -=1
    if arr1[i] not in c.keys() :
        c[arr1[i]] = 1
    else :
        c[arr1[i]] +=1

for i in d.keys() :
    if d[i] != 0 :
        print(i)
for i in range(len(arr2)) :
    c[arr2[i]] -=1
for i in c.keys() :
    if c[i] != 0 :
        print(i)
