#!/usr/bin/python3
def solution():
    n = int(input())
    data = []
    for i in range(n):
        data.append([int(x) for x in input().split()])
    prevP, prevC = data[0]
    if prevC > prevP:
        print("NO")
        return
    for i in range(n - 1):
        curP, cutC = data[i+1]
        if curP < prevP or cutC < prevC or cutC > curP or (curP - prevP) < (cutC - prevC):
            print("NO")
            return
        prevC = cutC
        prevP = curP
    print("YES")

T = int(input())
for _ in range(1, T + 1):
    solution()









