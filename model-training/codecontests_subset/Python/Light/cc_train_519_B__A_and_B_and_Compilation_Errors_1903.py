n=int(input())
arr1=list(map(int, input().split(' ')))
arr2=list(map(int, input().split(' ')))
arr3=list(map(int, input().split(' ')))
arr1.sort()
arr2.sort()
arr3.sort()
for i in range(len(arr1)-1):
    if(arr1[i]!=arr2[i]):
        print(arr1[i])
        break
else:
    print(arr1[len(arr1)-1])

for i in range(len(arr2)-1):
    if(arr2[i]!=arr3[i]):
        print(arr2[i])
        break
else:
    print(arr2[len(arr2)-1])