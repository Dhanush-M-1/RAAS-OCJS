from sys import stdin


def inp():
    return stdin.buffer.readline().rstrip().decode("utf8")


def itg():
    return int(stdin.buffer.readline())


def mpint():
    return map(int, stdin.buffer.readline().split())


# ############################## import

# ############################## main

for case in range(itg()):
    n, m = mpint()
    s1 = set(mpint())
    s2 = set(mpint())
    s3 = s1 & s2
    if s3:
        print("YES")
        print(1, s3.pop())
    else:
        print("NO")

# Please check!
