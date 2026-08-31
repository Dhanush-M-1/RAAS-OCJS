input()
arr1 = list(map(int, input().split()))
arr2 = list(map(int, input().split()))
arr3 = list(map(int, input().split()))
arr1.sort()
arr2.sort()
arr3.sort()
flag1 = 0
flag2 = 0
ans1 = ans2 = 0
for i in range(len(arr1)):
    if(flag1 == 1 and flag2 ==1):
        break
    if(flag1 == 0):
        if(i == len(arr1)-1):
            ans1 = arr1[i]
            flag1 = 1
        elif(arr1[i]!=arr2[i]):
            ans1 = arr1[i]
            flag1 = 1
    if(flag2 == 0):
        if(i == len(arr1)-2):
            ans2 = arr2[i]
            flag2 = 1
        elif(arr2[i]!=arr3[i]):
            ans2 = arr2[i]
            flag2 = 1

print(ans1)
print(ans2)