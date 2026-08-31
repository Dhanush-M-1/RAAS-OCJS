import sys, os, re
from math import *
from random import *

class Answer(BaseException):
	def __init__(self, txt):
		self.__text = txt
	def what(self):
		return self.__text
def answer(arg):
	raise Answer
def lcm(a, b: int):
	return a * b // gcd(a, b)
def readArr(__type):
    return list(map(__type, input().split()))
def chomp(s: str):
    return (s[:-1] if s[-1] == '\n' else s)
def readFile(name: str):
    f = open(name, "r");
    r = f.readlines();
    f.close()
    return r
def init_all():
    sys.setrecursionlimit(max(sys.getrecursionlimit(), 500000))

def lower_bound(a, k):
    l, r = 0, len(a) - 1
    while l != r:
        mid = (l + r) // 2
        if a[mid] < k:
            l = mid + 1
        else:
            r = mid
    return l

def upper_bound(a, k):
    l, r = 0, len(a) - 1
    while l + 1 < r:
        mid = (l + r) // 2
        if a[mid] <= k:
            l = mid
        else:
            r = mid - 1
    if a[r] == k:
        return r
    else:
        return l
 
def solve():
    input()
    a = sum(readArr(int))
    b = sum(readArr(int))
    c = sum(readArr(int))
    print(a - b)
    print(b - c)

    
def main(argv: list):
    init_all();
    t = 1
#    t = int(input())
    for __ in range(t):
        solve()
    return 0

if (__name__ == "__main__"):
    try:
        exit(main(sys.argv))
    except Answer as a:
        print(a.what())
        exit(0)
    except Exception as e:
        print("An exception occured: ", *e.args, "\n", type(e), sep="")
        exit(-1)
