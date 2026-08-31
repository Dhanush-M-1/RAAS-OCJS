import sys
from collections import defaultdict
import math

MAXNUM = math.inf
MINNUM = -1 * math.inf
ASCIILOWER = 97
ASCIIUPPER = 65


def getInt():
    return int(sys.stdin.readline().rstrip())


def getInts():
    return map(int, sys.stdin.readline().rstrip().split(" "))


def getString():
    return sys.stdin.readline().rstrip()


def getDivisors(x):
    if x == 1:
        return [1]
    if x == 2:
        return [2]
    f = []
    MAX = math.sqrt(x) + 1
    cur = 2
    while cur <= x and cur < MAX:
        if x % cur == 0:
            f.append(cur)
            x //= cur
        else:
            cur += 1
        if len(f) > 2:
            break
    if x > 1:
        f.append(x)
    return f


def printOutput(ans):
    if ans[0] == 1:
        sys.stdout.write(str(ans[0]) + "\n")
        sys.stdout.write(str(ans[1]) + "\n")
    else:
        sys.stdout.write(str(ans[0]) + "\n")


def solve(x):
    factors = getDivisors(x)
    if len(factors) == 1:
        return 1, 0

    elif len(factors) == 2:
        return [2]
    else:
        ans = factors[0] * factors[1]
        return 1, ans


def readinput():
    x = getInt()
    printOutput(solve(x))


readinput()
