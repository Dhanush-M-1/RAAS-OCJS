
import sys
#
# name = "input1.txt"
#
# sys.stdin = open( name )



def isPossible(PC):
    p,c=PC[0][0],PC[0][1]
    if c>p:
        print('NO')
        return
    for i in range(1,len(PC)):
        p0,c0=PC[i-1][0],PC[i-1][1]
        p1, c1 = PC[i][0], PC[i][1]
        if c1>p1 :
            print('NO')
            return
        if p0 > p1:
            print('NO')
            return
        if c0>c1 :
            print('NO')
            return
        if (c1-c0)>(p1-p0):
            print('NO')
            return
    print('YES')

input = sys.stdin.readline


def inp():
    return (int(input()))


def inlt():
    return (list(map(int, input().split())))


def insr():
    s = input()
    return (list(s[:len(s) - 1]))


def invr():
    return (map(int, input().split()))


def f(a, n):
    return True


def is_permutation(arr):
    for e in range(1, len(arr) + 1):
        if e not in arr:
            return False
    return True


t = inp()
for i in range(t):
    n = inp()
    PC=[]
    for i in range(n):
        PC.append(inlt())
    isPossible(PC)