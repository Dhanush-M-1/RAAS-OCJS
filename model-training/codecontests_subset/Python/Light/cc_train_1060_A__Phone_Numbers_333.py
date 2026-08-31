# import sys
# input=sys.stdin.readline

n=int(input())
a=input()
b=a.count("8")
d=[]
for i in range(b):
    d.append(min((n-(i+1))//10,(i+1)))
if len(d)==0:
    print(0)
    exit()
print(max(d))