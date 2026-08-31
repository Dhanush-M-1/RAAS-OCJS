'''
sys.stdin.readline() instead of input() and using PyPy instead of Python speeds up this solution greatly.
'''
from sys import stdin
t = int(stdin.readline())

for i in range(t):
    l, r, d = map(int, stdin.readline().split())

    if (d < l):
        print(d)
    else:
        print(d * (r//d + 1))
