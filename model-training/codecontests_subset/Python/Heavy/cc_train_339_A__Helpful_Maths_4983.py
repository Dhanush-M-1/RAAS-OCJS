import math
import sys

n = input().split("+")
c1 = 0
c2 = 0
c3 = 0
c = 0
for i in range(len(n)):
    if(n[i]=="1"):
        c1 = c1 + 1
    elif(n[i]=="2"):
        c2 = c2 + 1
    else:
        c3 = c3 + 1
for i in range(c1):
    if(c!=0):
        sys.stdout.write('+')
    else:
        c = 1
    sys.stdout.write('1')
for i in range(c2):
    if(c!=0):
        sys.stdout.write('+')
    else:
        c = 1
    sys.stdout.write('2')
for i in range(c3):
    if(c!=0):
        sys.stdout.write('+')
    else:
        c = 1
    sys.stdout.write('3')

