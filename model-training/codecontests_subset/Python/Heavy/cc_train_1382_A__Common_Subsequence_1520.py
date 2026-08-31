def intersection(alist: list, blist: list) -> int:
    for ele in alist:
        if ele in blist:
            return ele
    return -1


t = int(input())

AList = list(list())
BList = list(list())
for _ in range(t):
    __ = input()
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    AList.append(a)
    BList.append(b)

for i in range(len(AList)):
    k = intersection(AList[i], BList[i])

    if k != -1:
        print("Yes")
        print(1, k)
    else:
        print("No")
