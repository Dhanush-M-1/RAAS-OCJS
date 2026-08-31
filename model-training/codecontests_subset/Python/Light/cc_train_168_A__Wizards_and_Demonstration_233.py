import sys

def input():    return sys.stdin.readline().strip()
def iinput():   return int(input())
def rinput():   return map(int, sys.stdin.readline().strip().split()) 
def get_list(): return list(map(int, sys.stdin.readline().strip().split())) 


n,x,y=rinput()

a=y*n/100

if(int(a)==a):
    s=a
else:
    s=a+1

if(int(s-x)>0):
    print(int(s-x))
else:
    print(0)