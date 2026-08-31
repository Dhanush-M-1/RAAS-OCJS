n = int(input())
errorA = list(map(int,input().split()))
errorB = list(map(int,input().split()))
errorC = list(map(int,input().split()))
errorA.sort()
errorB.sort()
errorC.sort()
# print(*errorA)
# print(*errorB)
# print(*errorC)
i = 0
while i <= n-2 :
    if errorA[i] != errorB[i]:
        print(errorA[i])
        break
    i+=1
if i == n-1:
    print(errorA[n-1])
i = 0
while i <= n-3 :
    if errorB[i] != errorC[i]:
        print(errorB[i])
        break
    i+=1
if i == n-2:
    print(errorB[n-2])

