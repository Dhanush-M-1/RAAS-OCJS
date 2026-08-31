def readintlst():
    return list(map(int, input().split(' ')))


def readn():
    return int(input())


import math


# print(math.log(15116544*4, 6))
# print('a', 6**9 / 15116544)
for _ in range(readn()):
    n = readn()
    i = j = 0
    while n / 3  == int(n /3):
        j+=1
        n = n // 3
    while n / 2 == int(n/2):
        i +=1
        n = n // 2
    if n != 1:
        print(-1)
    else:
        steps = 0
        if i <= j:
            print(2*j - i)
        else:
            print(-1)

