from sys import stdin


def inp():
    return (ss.rstrip() for ss in stdin).__next__()

def itg():
    return int(inp())

def mpint():
    return map(int, inp().split())

# 0123210 (odd)
# 01234210 01243210

def solve():
    increasing = True
    for i in range(1, n):
        if arr[i - 1] >= arr[i]:
            increasing = False
            break
    if increasing:
        return "Yes"
    decreasing = True
    for i in range(1, n):
        if arr[i - 1] <= arr[i]:
            decreasing = False
            break
    if decreasing:
        return "Yes"
    if r:  # odd
        for i in range(q + 1):  # 0123
            if arr[i] < i:
                return "No"
        for i in range(q + 1):  # 0123
            if arr[-i-1] < i:
                return "No"
        return "Yes"

    # even (q = 4)
    elif arr[q] >= q:  # type 1 01234210
        for i in range(q + 1):  # 01234
            if arr[i] < i:
                return "No"
        for i in range(q-1):  # 012
            if arr[-i-1] < i:
                return "No"
        return "Yes"
    else:  # type 2 01243210
        for i in range(q - 1):  # 012
            if arr[i] < i:
                return "No"
        for i in range(q+1):  # 01234
            if arr[-i-1] < i:
                return "No"
        return "Yes"


for case in range(itg()):
    n = itg()
    arr = tuple(mpint())
    if n == 1:
        print("Yes")
        continue
    elif n == 2:
        if arr == (0, 0):
            print("No")
        else:
            print("Yes")
        continue
    q, r = divmod(n, 2)
    print(solve())
