from sys import stdin,stderr,maxsize
mod = int(1e9)+7
def I(): return int(stdin.readline())
def lint(): return [int(x) for x in stdin.readline().split()]
def S(): return input().strip()
def grid(r, c): return [lint() for i in range(r)]
def debug(*args, c=6): print('\033[3{}m'.format(c), *args, '\033[0m', file=stderr)
from collections import Counter,defaultdict
from itertools import permutations

def bark():
    s =S()
    x =[S() for i in range(I())]
    for i in x:
        for j in x:
            if s in i+j:
                return "YES"
    return "NO"
if __name__ == '__main__':
    print(bark())

