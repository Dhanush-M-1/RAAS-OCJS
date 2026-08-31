# coding=utf-8 
# Created by TheMisfits 
from sys import stdin
_input = stdin.readline
_range, _list, _str, _int = range, list, str, int
def solution():
    for _ in _range(_int(_input())):
        n = _int(_input())
        arr = []
        for i in _range(n):
            arr.append(_list(_input().rstrip('\n')))
        a,b,c,d = _int(arr[0][1]), _int(arr[1][0]), _int(arr[n-1][n-2]), _int(arr[n-2][n-1])
        l, r = a+b, c+d
        if l == 0 and r == 2 or l == 2 and r == 0:
            print(0)
        elif l == 0 and r == 0 or l == 2 and r == 2:
            print(2)
            print(1, 2)
            print(2, 1)
        elif r == 2:
            if a == 0:
                print(1)
                print(2, 1)
            else:
                print(1)
                print(1, 2)
        elif l == 2:
            if c == 0:
                print(1)
                print(n-1, n)
            else:
                print(1)
                print(n, n - 1)
        elif l == 0:
            if c == 0:
                print(1)
                print(n, n - 1)
            else:
                print(1)
                print(n - 1, n)
        elif r == 0:
            if a == 0:
                print(1)
                print(1, 2)
            else:
                print(1)
                print(2, 1)
        else:
            if a == 0:
                print(2)
                print(1, 2)
                if c == 0:
                    print(n-1, n)
                else:
                    print(n, n-1)
            else:
                print(2)
                print(2, 1)
                if c == 0:
                    print(n - 1, n)
                else:
                    print(n, n - 1)



solution()