# coding: utf-8
# Your code here!
n=int(input())
def dfs(s):
    if len(s)==n:
        print(s)
    else:
        for i in range(ord("a"),ord(max(s))+1+1): #"a"スタートで、max(s)+1("a"の分)+1(右端)
            dfs(s+chr(i))
dfs("a")
