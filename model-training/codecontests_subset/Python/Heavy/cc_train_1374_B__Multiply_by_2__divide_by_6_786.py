import sys
sys.setrecursionlimit(100000)

def read(): return int(input())
def get_ints(): return map(int, sys.stdin.readline().strip().split())
def get_array(): return list(map(int, sys.stdin.readline().strip().split()))
def input(): return sys.stdin.readline().strip()

cas = read()

while cas:
    cas -= 1
    x = read()
    two, six = 0, 0 
    while x % 2 == 0:
        x /= 2
        two += 1
    while x % 3 == 0:
        x /= 3
        six += 1
    if x != 1 or two > six:
        print(-1)
    else:
        print(six * 2 - two)
