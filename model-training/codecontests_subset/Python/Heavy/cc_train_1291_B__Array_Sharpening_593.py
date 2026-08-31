from sys import stdin


def input():
    return stdin.readline()[:-1]


def intput():
    return int(input())


def sinput():
    return input().split()


def intsput():
    return map(int, sinput())


debugging = False
def dprint(*args):
    if debugging:
        print(*args)
    else:
        pass



# Code

t = intput()
for _ in range(t):
    n = intput()

    a = list(intsput())
    forward = [False] * n
    backward = [False] * n


    for i in range(n):
        if a[i] >= i:
            forward[i] = True
    
    for i in range(n):
        if a[-i - 1] >= i:
            backward[-i - 1] = True
    
    x = 0
    while x < n and forward[x]:
        x += 1
    if x == n:
        print("Yes")
        continue
    else:
        x -= 1
    while x < n and backward[x]:
        x += 1
    
    if x == n:
        print("Yes")
    else:
        print("No")
