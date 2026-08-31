from sys import stdin, stdout
from collections import Counter,deque
import math
input = stdin.readline
print = stdout.write
def inpn():
    return(int(input()))
def inpl():
    return(list(map(int,input().split())))
def inps():
    return input()
def invr():
    return (map(int, input().split()))
def outs(s):
    print(s)
def outn(n):
    print(str(n))
def outl(l):
    for i in l:
        print(str(i))


for _ in range(int(input())):
    n = inpn()
    l=inpl()

    def bin_search(data, target):  # order of log(n)   # works only on sorted list
        low = 0
        high = len(data) - 1

        while low <= high:
            mid = (low + high) // 2
            if data[mid] >= target:
                return mid
            elif data[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1


    for i in range(n - 2):
        a = bin_search(l, l[i] + l[i + 1])
        if a != -1:
            outn(i + 1)
            print(" ")
            outn(i+2)
            print(" ")
            outn(a+1)
            print("\n")
            break
    else:
        outn(-1)
        print("\n")