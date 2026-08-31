import sys
input = sys.stdin.readline
from collections import Counter

############ ---- Input Functions ---- ############
def inp():
    return(int(input()))
def inlt():
    return(list(map(int,input().split())))
def insr():
    s = input()
    return(list(s[:len(s) - 1]))
def invr():
    return(map(int,input().split()))

def print_list_int(l):
    print("".join(map(str, map(int, l))))

if __name__ == "__main__":
    t = inp()
    for test in range(t):
        n = inp()
        peeks = []
        last = (-1,-1)
        possible = True
        for i in range(n):
            p_old, c_old = last
            p, c = inlt()
            if p < p_old or c < c_old or p-p_old < c-c_old:
                possible = False
            last = (p,c)
        if possible:
            print("YES")
        else:
            print("NO")