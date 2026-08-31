import sys

def input():    return sys.stdin.readline().strip()
def iinput():   return int(input())
def rinput():   return map(int, sys.stdin.readline().strip().split()) 
def get_list(): return list(map(int, sys.stdin.readline().strip().split())) 


n=iinput()
m=input()
s=sorted(list(m))
l=[]
p=[]
for i in range(len(m)):
    if(i%n==0):
        l.append(s[i])
l1="".join(l)
#print(l1)
for i in range(n):
    p.append(l1)
p1="".join(p)
s1= sorted(p1)
if(s1!=s):
    print(-1)
else:
    print(p1)
    