n = int(input())
myList = list(map(int, input().split()))
myNewList = []
for i in range(0, len(myList)):
    if myList[i] < 500001:
        x = myList[i] - 1
    elif myList[i] >= 500001:
        x = abs(myList[i] - 1000000)
    myNewList.append(x)
maxi = 0
for j in range(0, len(myNewList)):
    if myNewList[j] > maxi:
        maxi = myNewList[j]
print(maxi)
