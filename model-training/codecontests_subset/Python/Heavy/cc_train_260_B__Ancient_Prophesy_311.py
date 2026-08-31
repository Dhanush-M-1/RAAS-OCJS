from collections import deque
from math import log,sqrt,ceil
def ii(): return int(input())
def si(): return input()
def mi(): return map(int,input().strip().split(" "))
def li(): return list(mi())
s=si()
a=[]
s1=""
f=1
mon=[0,31,28,31,30,31,30,31,31,30,31,30,31]
for i in range(len(s)):
    if(s[i]=='-'):
        a.append(s[i])
        if(s1!=""):
            if(len(s1)==1):
                a.append(int(s1))
            elif(len(s1)>=4 and f):
                a.append(int(s1[:4]))
                a.append(int(s1[-2:]))
            else:
                a.append(int(s1[-2:]))
            s1=""
            f=1
        else:
            f=0
    else:
        s1+=s[i]
a.append('-')
if(len(s1)==1):
    a.append(int(s1))
elif(len(s1)>=4):
    a.append(int(s1[:4]))
else:
    a.append(int(s1[-2:]))
m={}
for i in range(len(a)):
    x,y=0,0
    if(a[i]!='-' and a[i]>=2013 and a[i]<=2015):
        if(i-2>=0 and a[i-2]!='-'):
            x=a[i-2]
        if(i-4>=0 and a[i-4]!='-'):
            y=a[i-4]
        if(x>=1 and x<=12):
            if(y>0 and y<=mon[x]):
                tup=(y,x,a[i])
                if tup not in m:
                    m[tup]=1
                else:
                    m[tup]+=1
x=0
for i in m.keys():
    if(m[i]>x):
        x=m[i]
        y=i
dd=y[0]
if(dd<10):
    dd='0'+str(dd)
mm=y[1]
if(mm<10):
    mm='0'+str(mm)
yy=y[2]
s=str(dd)+'-'+str(mm)+'-'+str(yy)
print(s)



