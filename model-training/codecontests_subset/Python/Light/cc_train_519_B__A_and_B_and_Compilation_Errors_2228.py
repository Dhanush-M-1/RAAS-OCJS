from sys import stdin,stdout

num = int(stdin.readline())

arr1 = sorted(list(map(int,stdin.readline().split())))
arr2 = sorted(list(map(int,stdin.readline().split())))
arr3 = sorted(list(map(int,stdin.readline().split())))

for i in range(len(arr1)):
    try:


        if arr1[i] - arr2[i] !=0:
            print(arr1[i])
            break

    except IndexError:
        print(arr1[-1])


for j in range(len(arr2)):
    try:

        if arr2[j] - arr3[j] !=0:
            print(arr2[j])
            break

    except IndexError:
        print(arr2[-1])
