a, b = map(int, input().split(' '))
res = 0
q = 0
while (a+q) >= b:
    # print(a, q)
    res += a #dot
    went = a + q #xac nen
    a = went // b #nau lai nen
    q = went % b #thua nen khong nau duoc
print(res+a)