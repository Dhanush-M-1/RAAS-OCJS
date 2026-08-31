from math import ceil
n,x,y = map(int,input().split(" "))

Answer = 0
if (y/100) * n >= x :
    Answer = ((y/100) * n) - x

print(ceil(Answer)) 