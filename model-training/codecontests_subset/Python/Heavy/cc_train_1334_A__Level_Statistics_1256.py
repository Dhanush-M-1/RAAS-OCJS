t = int(input())
for i in range(t):
    n = int(input())
    array = []
    for j in range(n):
        p, c = [int(s) for s in input().split()]
        array.append((p, c))
    flag = True
    for i in range(len(array) - 1):
        if array[i][0] > array[i + 1][0] or array[i][1] > array[i + 1][1] or (array[i + 1][1] - array[i][1] > array[i + 1][0] - array[i][0]):
            flag = False
            break
    for i in range(len(array)):
        if array[i][0] < array[i][1]:
            flag = False
            break
    if flag:
        print("YES")
    else:
        print("NO")