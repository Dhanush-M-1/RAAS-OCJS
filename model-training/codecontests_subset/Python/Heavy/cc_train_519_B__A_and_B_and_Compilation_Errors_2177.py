n = int(input())
Arr = list(map(int, input().split()))

HashMap = {}

for no in Arr:
    if no not in HashMap:
        HashMap[no] = 1
    else:
        HashMap[no] += 1

Arr = list(map(int, input().split()))
newHashMap = {}

for no in Arr:
    if no not in newHashMap:
        newHashMap[no] = 1
    else:
        newHashMap[no] += 1

for no in HashMap:
    if (no not in newHashMap) or HashMap[no] != newHashMap[no]:
        print(no)
        break

HashMap = newHashMap
newHashMap = {}
Arr = list(map(int, input().split()))

for no in Arr:
    if no not in newHashMap:
        newHashMap[no] = 1
    else:
        newHashMap[no] += 1

for no in HashMap:
    if (no not in newHashMap) or HashMap[no] != newHashMap[no]:
        print(no)
        break
