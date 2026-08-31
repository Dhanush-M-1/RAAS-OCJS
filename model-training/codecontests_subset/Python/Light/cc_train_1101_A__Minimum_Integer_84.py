from math import ceil
def slve(l,r,d):
    if (l-1)//d>=1:return d
    return ceil((r+1)/d)*d
for _ in range(int(input())):
    l,r,d=map(int,input().split());print(slve(l,r,d))