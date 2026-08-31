t = int(input())

arr1 = input()
arr1 = arr1.split()
arr1 = list(map(int, arr1))

arr2 = input()
arr2 = arr2.split()
arr2 = list(map(int, arr2))

arr3 = input()
arr3 = arr3.split()
arr3 = list(map(int, arr3))


arr1sum = 0
arr2sum = 0
arr3sum = 0
for x in arr1:
    arr1sum = arr1sum + x
for x in arr2:
    arr2sum = arr2sum + x
for x in arr3:
    arr3sum = arr3sum + x

print(arr1sum - arr2sum)
print(arr2sum - arr3sum)