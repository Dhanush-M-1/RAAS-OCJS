# Aizu Problem 00163: Highway Tooll
#
import sys, math, os, bisect

# read input:
PYDEV = os.environ.get('PYDEV')
if PYDEV=="True":
    sys.stdin = open("sample-input.txt", "rt")

M = [[0, 300, 500, 600, 700,1350,1650],
     [6,   0, 350, 450, 600,1150,1500],
     [13,   7,   0, 250, 400,1000,1350],
     [18,  12,   5,   0, 250, 850,1300],
     [23,  17,  10,   5,   0, 600,1150],
     [43,  37,  30,  25,  20,   0, 500],
     [58,  52,  45,  40,  35,  15,   0]]

def intime(t):
    return 1730 <= t <= 1930

def getinfo(src, dst):
    if src > dst:
        src, dst = dst, src
    return M[dst][src], M[src][dst]

while True:
    n1 = int(input())
    if n1 == 0:
        break
    h1, m1 = [int(_) for _ in input().split()]
    n2 = int(input())
    h2, m2 = [int(_) for _ in input().split()]
    t1, t2 = 100 * h1 + m1, 100 * h2 + m2
    a, b = getinfo(n1 - 1, n2 - 1)
    if (intime(t1) or intime(t2)) and a <= 40:
        b = (b // 2 + 49) // 50 * 50
    print(b)