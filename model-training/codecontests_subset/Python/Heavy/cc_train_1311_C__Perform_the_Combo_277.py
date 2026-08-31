import sys

t = int(sys.stdin.readline())

for _ in range(t):
    n, m = map(int, sys.stdin.readline().split())
    combo = sys.stdin.readline()
    ps = list(map(int, sys.stdin.readline().split()))
    arr1 = []
    sumVal = [0]*126

    for i in range(n):
        if i == 0:
            temp = [0]*126
            temp[ord(combo[i])] += 1
            arr1.append(temp)
        else:
            temp = []
            for j in range(len(arr1[-1])):
                temp.append(arr1[-1][j])
            arr1.append(temp)
            arr1[-1][ord(combo[i])] += 1
    for p in ps:
        for i in range(26):

            sumVal[i] += arr1[p-1][ord("a")+i]
    for j in range(26):
        sumVal[j] += arr1[-1][ord("a")+j]
    sumVal = sumVal[:26]
    for k in range(len(sumVal)):
        if k == len(sumVal) - 1:
            print(sumVal[k])
        else:
            print(sumVal[k], end=" ")
