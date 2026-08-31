#!/usr/bin/env pypy
n=int(input())
a=[int(x) for x in input().split()]
e=[]
o=[]

for i in a:
    if i%2==0:
        e.append(i)
    else:
        o.append(i)
e.sort()
o.sort()
"""ev=False
od=False"""

if (len(o) > len(e)):
    o.pop()
    while(len(e)>0):
        e.pop()
        o.pop()
elif len(o)==len(e):
    while(len(e)>0):
        e.pop()
        o.pop()
else:
    e.pop()
    while len(o)>0:
        o.pop()
        e.pop()

"""while(len(e)>0 and len(o)>0):
    if (len(o)>len(e)):
        o.pop()
    elif(len(o)<len(e)):
        e.pop()
    else:
        o.pop()
        e.pop()"""

print(sum(o)+sum(e))