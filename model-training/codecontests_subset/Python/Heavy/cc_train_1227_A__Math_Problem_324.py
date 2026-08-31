t = int(input())
a = []
for i in range(t):
    n = int(input())
    arr = []
    for j in range(n):
        str = input().split()
        arr.append([int(str[0]), int(str[1])])
    a.append(arr)
for i in range(len(a)):
    arr = a[i]
    max_e = 0
    min_e = 1000000000
    for j in range(len(arr)):
        if arr[j][0] > max_e:
            max_e = arr[j][0]
        if arr[j][1] < min_e:
            min_e = arr[j][1]
    if min_e >= max_e:
        print(0)
    else:
        # print(min_e)
        # print(max_e)
        print(max_e - min_e)