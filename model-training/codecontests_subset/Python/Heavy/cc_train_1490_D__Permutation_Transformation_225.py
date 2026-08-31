from sys import stdin, stdout
from collections import Counter,deque
import math

'''
s = stdin.readline().strip()
n = int(int(stdin.readline()))
n, k = map(int, stdin.readline().split())
arr = list(map(int, stdin.readline().split()))
'''

class Node:

    def __init__(self, data):
        self.left = None
        self.right = None
        self.data = data

for test in range(int(input())):
    n = int(int(stdin.readline()))
    arr = list(map(int, stdin.readline().split()))
    d = [0] * n
    def haha(arr,i,st,en):
        if arr[st:en]:
            maxi = arr.index(max(arr[st:en]))
            d[maxi] = i
            haha(arr,i+1,st,maxi)
            haha(arr,i+1,maxi+1,en)
        #print(i)

    haha(arr,0,0,n)
    print(*d)




