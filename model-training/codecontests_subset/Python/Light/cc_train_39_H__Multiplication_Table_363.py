def baseNum(a,b):
    i = 0
    sumV = []
    while a > 0:
        sumV.append(str(a % b) )
        a = int(a/b)
        i += 1
    res = sumV[::-1]
    res2 = "".join(res)
    res2 = int(res2)
    return res2
k = int(input())
for i in range(1,k):
    for j in range(1,k):
        print(baseNum(i*j,k),end=" " )
    print(end="\n")