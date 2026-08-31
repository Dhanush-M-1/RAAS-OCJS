import sys
from statistics import mean

input = sys.stdin.readline


############ ---- Input Functions ---- ############
def inp():
    return (int (input ()))


def inlt():
    return (list (map (int, input ().split ())))


def insr():
    s = input ()
    return (list (s[:len (s) - 1]))


def invr():
    return (map (int, input ().split ()))


t = inp ()
for i in range (t):
    n = inp ()
    flag = 1
    x = None
    y = None
    for j in range(n):
        a, b = invr()
        if b > a:
            flag = 0
            continue
        if flag == 0:
            continue
        elif flag == 1:
            if x is None and y is None:
                x = a
                y = b
            else:
                m = a - x
                n = b - y
                if (m < 0) or (n < 0) or (n > m):
                    flag = 0
                else:
                    x = a
                    y = b
    if flag == 1:
        print("YES")
    else:
        print("NO")