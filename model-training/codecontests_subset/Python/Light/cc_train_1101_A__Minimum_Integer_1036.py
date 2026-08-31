import random


def ii():
    return int(input())


def mi():
    return map(int, input().split())


def li():
    return list(mi())

q = ii()
while q > 0:
    l,r,d = tuple(mi())
    if l//d == 1:
        if d*(l//d) <l:
            print(d*(l//d))
            q -=1
            continue
    elif l//d > 1:
        print(d)
        q -=1
        continue


    if d*(r//d) <= r:
        print(d*(r//d + 1))
    else:
        print(d*(r//d))

    q= q-1
   # print("q "+str(q))
