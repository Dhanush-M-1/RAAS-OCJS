import sys
input = sys.stdin.readline
def I():return input().strip()
def II():return int(input().strip())
def LI():return [*map(int,input().strip().split())]
import math

n,k = map(int,input().split())
lst = LI()
lst.sort(reverse = True)
for i in range(n):
    if k%lst[i] == 0:
        print(k//lst[i])
        break



