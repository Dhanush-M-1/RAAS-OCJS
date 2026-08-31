from collections import defaultdict, deque, Counter, OrderedDict
from bisect import insort, bisect_right, bisect_left
import threading, sys

def main():
    n = int(input())
    s = [c for c in input()]
    pos = []
    for i,c in enumerate(s):
        if c == '*':
            pos.append(i+1)
    arr = [0]*(102)
    for c in pos: arr[c] = 1
    for i in range(1,101):
        for k in pos:
            check = 0
            for j in range(5):
                if k + j*i < 102:
                    check += arr[k + j*i]
            if check == 5:
                print("yes")
                exit(0)
    print("no")




if __name__ == "__main__":
    """sys.setrecursionlimit(400000)
    threading.stack_size(40960000)"""
    thread = threading.Thread(target=main)
    thread.start()
