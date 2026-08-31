n = int(input())
a = list(map(int, input().split()))
a1 = sorted(a, key=lambda x: -x)
q = int(input())
for i in range(q):
    k, pos = map(int, input().split())
    pos -= 1
    notused = {}
    for j in a1[:k]:
        if j in notused:
            notused[j] += 1
        else:
            notused[j] = 1
    for j in a:
        if j in notused:
            if pos > 0:
                if notused[j] > 1:
                    notused[j] -= 1
                else:
                    notused.pop(j)
                pos -= 1
            else:
                print(j)
                break
