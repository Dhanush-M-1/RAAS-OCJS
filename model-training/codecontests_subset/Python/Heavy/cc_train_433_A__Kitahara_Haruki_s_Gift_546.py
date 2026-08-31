import sys

def input():    return sys.stdin.readline().strip()
def iinput():   return int(input())
def rinput():   return map(int, sys.stdin.readline().strip().split()) 
def get_list(): return list(map(int, sys.stdin.readline().strip().split())) 


n=iinput()
s=list(map(int, input().split()))
l=(sum(s)//100)
p=[]
if(n==1):
    print("NO")
else:
    if(n%2==0):
        if(l%2==0):
            print("YES")
        else:
            print("NO")
    else:
        for i in range(n):
            p.append(200)
        if(p==s):
            print("NO")
        else:
            if(l%2==0):
                print("YES")
            else:
                print("NO")
            

