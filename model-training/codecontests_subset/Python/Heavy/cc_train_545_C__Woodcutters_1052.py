from __future__ import print_function
import sys
from collections import *
from heapq import *
INF=float("inf")
NINF=float("-inf")

try:
    input=raw_input
except:
    pass

def read_string():
    return input()

def read_int_line():
    return [int(x) for x in input().split(" ")]

def read_int():
    return int(input())

class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
    def __str__(self):
        q=deque()
        ans=[]
        q.append(self)
        ans.append(self.val)
        while q:
            cur=q.popleft()
            ans.append(cur.left.val if cur.left else "null")
            ans.append(cur.right.val if cur.right else "null")
            if cur.left:
                q.append(cur.left)
            if cur.right:
                q.append(cur.right)
        while ans and ans[-1] == "null":
            ans.pop()
        return str(ans).replace("'null'", 'null')

def toTreeNode(s):
    l = eval(s.replace("null", "None"))
    n=len(l)
    if not n:
        return None
    root=TreeNode(l[0])
    q=deque()
    q.append(root)
    i=1
    while q and i < n:
        cur=q.popleft()
        if l[i] != None:
            cur.left = TreeNode(l[i])
            q.append(cur.left)
        i+=1
        if i>=n:
            break
        if l[i] != None:
            cur.right=TreeNode(l[i])
            q.append(cur.right)
        i+=1
    return root

class Djs:
    def __init__(self, n):
        self.w=[1]*n
        self.p=[-1]*n
    def find(self, x):
        p=self.p[x]
        if p==-1:
            return x
        else:
            self.p[x]=self.find(p)
            return self.p[x]
    def union(self, x, y):
        x,y=self.find(x),self.find(y)
        if x==y:
            return
        if self.w[x]>self.w[y]:
            x,y=y,x
        self.p[x]=y
        self.w[y]+=self.w[x]
    def roots(self):
        return [x for x, y in enumerate(self.p) if y==-1]

def doit():
    n=read_int()
    l=[]
    for _ in range(n):
        x,h=read_int_line()
        l.append((x,h))
    ans=0
    lastx=-1
    for i, (x,h) in enumerate(l):
        if i==0:
            ans+=1
            lastx=x
        elif x-h>lastx:
            ans+=1
            lastx=x
        elif i+1==n or x+h<l[i+1][0]:
            ans+=1
            lastx=x+h
        else:
            lastx=x
    print("%d"%ans)


if __name__ == "__main__":
    try:
        while True:
            doit()
    except EOFError:
        pass


