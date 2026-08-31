t=int(input())

for i in range(t):
    space = input()
    k,n,m = map(int, input().split())
    taskN = list(map(int, input().split()))
    taskM = list(map(int, input().split()))
    ans = []
    possible = 0
    while (len(taskM) > 0 or len(taskN) > 0):
        lenM = len(taskM)
        lenN = len(taskN)
        if (lenM > 0 and taskM[0] == 0):
            k+=1
            ans.append(0)
            taskM.pop(0)
        elif (lenN>0 and taskN[0] == 0):
            k+=1
            ans.append(0)
            taskN.pop(0)
        elif (lenN>0 and taskN[0] <= k):
            ans.append(taskN[0])
            taskN.pop(0)
        elif (lenM>0 and taskM[0] <= k):
            ans.append(taskM[0])
            taskM.pop(0)
        else:
            possible = 1
            break

    if (possible == 1):
        print(-1)
    else:
        print(*(ans))