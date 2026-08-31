import sys
'''sys.stdin = open('input.txt', 'r')  
sys.stdout = open('output.txt', 'w') '''
from collections import defaultdict as dd
from math import *
from bisect import *
#sys.setrecursionlimit(10 ** 8)
def sinp():
    return input()
def inp():
    return int(input())
def minp():
    return map(int, input().split())
def linp():
    return list(minp())
def strl():
    return list(input())
def pr(x):
    print(x)
mod = int(1e9+7)
class newNode: 
    def __init__(self, data): 
        self.data = data  
        self.left = None
        self.right = None
def buildTree (inorder, start, end): 
    if start > end: 
        return None
    i = Max (inorder, start, end)  
    root = newNode(inorder[i])  
    if start == end:  
        return root  
    root.left = buildTree (inorder, start, i - 1)  
    root.right = buildTree (inorder, i + 1, end)  
    return root 
def Max(arr, strt, end): 
    i, Max = 0, arr[strt] 
    maxind = strt 
    for i in range(strt + 1, end + 1): 
        if arr[i] > Max: 
            Max = arr[i]  
            maxind = i 
    return maxind 
def printInorder (node): 
    if node == None:  
        return
    printInorder (node.left)   
    print(node.data, end = " ") 
    printInorder (node.right) 
def getLevelUtil(node, data, level):
    if (node == None):
        return 0
    if (node.data == data):
        return level
    downlevel = getLevelUtil(node.left, data, level + 1)
    if (downlevel != 0):
        return downlevel
    downlevel = getLevelUtil(node.right, data, level + 1)
    return downlevel
def getLevel(node, data):
    return getLevelUtil(node, data, 1)
for _ in range(inp()):
    n = inp()
    a = linp()
    root = buildTree(a, 0, n - 1)  
    l = [0 for i in range(n)]
    d = dd(int)
    for i in range(1, n + 1):
        level = getLevel(root, i)
        d[i] = level - 1
    for i in range(n):
        l[i] = d[a[i]]
    print(*l)