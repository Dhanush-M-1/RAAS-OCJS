'''
sys.stdin.readline() instead of input() and using PyPy instead of Python speeds up this solution greatly.

stdout, takes only str as argument, also it does not end line like print do.
'''
from sys import stdin, stdout
t = int(stdin.readline())

for i in range(t):
    l, r, d = map(int, stdin.readline().split())

    if (d < l):
        stdout.write(str(d))
        stdout.write("\n")
    else:
        stdout.write(str(d * (r//d + 1)))
        stdout.write("\n")
