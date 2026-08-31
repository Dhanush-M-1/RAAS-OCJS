#Bhargey Mehta (Sophomore)
#DA-IICT, Gandhinagar
import sys, math, queue
sys.setrecursionlimit(1000000)
#sys.stdin = open("input.txt", "r")

for _ in range(int(input())):
    n = int(input())
    s = input()
    a1 = n+n
    a2 = n+n
    a = 0
    for i in range(n):
        if s[i] != '>':
            a += 1
        else:
            a1 = a
            break
    a = 0
    for i in range(-1, -1-n, -1):
        if s[i] != '<':
            a += 1
        else:
            a2 = a
            break
    print(min(a1, a2))