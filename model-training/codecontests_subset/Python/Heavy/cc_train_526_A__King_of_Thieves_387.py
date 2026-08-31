#!/usr/bin/python
import re
import inspect
from sys import argv, exit

def rstr():
    return input()

def rint():
    return int(input())

def rints(splitchar=' '):
    return [int(i) for i in input().split(splitchar)]

def varnames(obj, namespace=globals()):
    return [name for name in namespace if namespace[name] is obj]

def pvar(var, override=False):
    prnt(varnames(var), var)

def prnt(*args, override=False):
    if '-v' in argv or override:
        print(*args)

if __name__ == '__main__':
    n = rint()
    s = rstr()
    course = [1 if c=='*' else 0 for c in s]
    prnt(course)
    for i,c in enumerate(course):
        if not c:
            prnt(c)
            continue
        else:
            prnt('Using c=',i)
            for j in range(1, len(course)):
                if i+j*4 >= len(course):
                    break
                if course[i+j] and course[i+j*2] and course[i+j*3] and course[i+j*4]:
                    print('yes')
                    exit(0)

    print('no')
