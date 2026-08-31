# 519b (1) A and V and Compilation Errors
input()
errorDic = {}
errorDic2 = {}
answer = 0

for error in input().split():
    key = int(error)
    if key in errorDic:
        errorDic[key] += 1
        errorDic2[key] += 1
    else:
        errorDic[key] = 1
        errorDic2[key] = 1

for solved in input().split():
    key = int(solved)
    if key in errorDic:
        errorDic[key] -= 1

for key in list(errorDic.keys()):
    if(errorDic[key] == 1):
        answer = key
        print(answer)

errorDic2[answer] -= 1

for solved in input().split():
    key = int(solved)
    if key in errorDic2:
        errorDic2[key] -= 1

for key in list(errorDic.keys()):
    if(errorDic2[key] == 1):
        answer = key
        print(answer)

