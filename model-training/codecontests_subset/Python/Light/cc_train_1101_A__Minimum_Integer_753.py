from sys import stdin, stdout
from math import sin, tan, cos, pi, atan2, sqrt, acos, atan, factorial
from random import randint

q = int(stdin.readline())
for i in range(q):
    l, r, d = map(int, stdin.readline().split())
    
    if d < l:
        stdout.write(str(d) + '\n')
    else:
        stdout.write(str((r // d + 1) * d) + '\n')