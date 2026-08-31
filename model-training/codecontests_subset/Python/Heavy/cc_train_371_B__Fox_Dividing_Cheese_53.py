a, b = map(int, input().split())
p, q = a, b
aa = [0, 0, 0]
bb = [0, 0, 0]
flag, flags = 0, 0
while True:
    flag = 0
    if (a == 1):
        flag = 2
        break
    if (a % 2 == 0):
        aa[0] += 1
        a //= 2
        flag = 1
    elif (a % 3 == 0):
        aa[1] += 1
        a //= 3
        flag = 1
    elif (a % 5 == 0):
        aa[2] += 1
        a //= 5
        flag = 1
    if (flag == 0):
        flag = 3
        break
while True:
    flags = 0
    if (b == 1):
        flags = 22
        break
    if (b % 2 == 0):
        bb[0] += 1
        b //= 2
        flags = 1
    elif (b % 3 == 0):
        bb[1] += 1
        b //= 3
        flags = 1
    elif (b % 5 == 0):
        bb[2] += 1
        b //= 5
        flags = 1
    if (flags == 0):
        flags = 33
        break

if (p == q):
    print(0)
elif (a==b):
    print(max(aa[0], bb[0]) - min(aa[0], bb[0]) + max(aa[1], bb[1]) - min(aa[1], bb[1]) + max(aa[2], bb[2]) - min(aa[2],
                                                                                                                  bb[
                                                                                                                      2]))
else:
    print(-1)