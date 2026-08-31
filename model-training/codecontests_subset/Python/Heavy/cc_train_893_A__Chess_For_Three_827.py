#Bhargey Mehta (Sophomore)
#DA-IICT, Gandhinagar
import sys, math, queue, bisect
#ys.stdin = open("input.txt", "r")
MOD = 10**9+7
sys.setrecursionlimit(1000000)

n = int(input())
cp = {1, 2}
for _ in range(n):
    w = int(input())
    if w not in cp:
        print("NO")
        exit()
    else:
        if w == 1:
            if cp == {1, 2}: cp = {1, 3}
            else: cp = {1, 2}
        elif w == 2:
            if cp == {2, 3}: cp = {1, 2}
            else: cp = {2, 3}
        else:
            if cp == {1, 3}: cp = {2, 3}
            else: cp = {1, 3}
print("YES")
