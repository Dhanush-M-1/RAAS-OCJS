n = int(input())
arr1 = [int(i) for i in input().split()]
arr2 = [int(i) for i in input().split()]
arr3 = [int(i) for i in input().split()]
dct1 = {}
for i in arr1:
    dct1[i] = dct1.setdefault(i, 0) + 1
dct2 = {}
for i in arr2:
    dct2[i] = dct2.setdefault(i, 0) + 1

for i in arr2:
    if dct1[i] == 1:
        dct1.pop(i)
    else:
        dct1[i] -= 1

for i in arr3:
    if dct2[i] == 1:
        dct2.pop(i)
    else:
        dct2[i] -= 1

print(*dct1)
print(*dct2)








    


