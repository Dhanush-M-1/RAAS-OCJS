import sys
import math

def input():
    return sys.stdin.readline().strip()

def iinput():
    return [int(x) for x in sys.stdin.readline().split()]

def main():
    n = int(input())
    data = iinput()
    razn = 0
    maxx, minn = -1, 10**9 + 1
    for i in range(1, n):
        if data[i] == -1 and data[i - 1] != -1:
            maxx = max(maxx, data[i - 1])
            minn = min(minn, data[i - 1])
        elif data[i] != -1 and data[i - 1] == -1:
            maxx = max(maxx, data[i])
            minn = min(minn, data[i])
        elif data[i] != -1 and data[i - 1] != -1:
            razn = max(razn, abs(data[i] - data[i - 1]))
    if maxx == -1:
        print(0, 0)
    else:
        print(max(razn, (maxx - minn + 1) // 2), maxx - ((maxx - minn + 1) // 2))
    return

for qwerty in range(int(input())):
    main()
