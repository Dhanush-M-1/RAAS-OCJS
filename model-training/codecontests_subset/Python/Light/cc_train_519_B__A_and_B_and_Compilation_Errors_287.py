n=0


input()
arr1 = list(map(int , input().split()))
arr2 = list(map(int , input().split()))
arr3 = list(map(int , input().split()))

arr1.sort()
arr2.sort()
arr3.sort()

while len(arr1)!=1:
    if arr2[n] in arr1:
        arr1.remove(arr2[n])
    n+=1

n=0

while len(arr2)!=1:
    if arr3[n] in arr2:
        arr2.remove(arr3[n])
    n+=1

for x in arr1:
    print(x)
for y in arr2:
    print(y)
