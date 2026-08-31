import sys
n=int(input())
ar=list(map(int,sys.stdin.readline().split()))
an=0
for el in ar:
    if el <= 500000:
        an=el-1
    else:
        an = max(an,1000000-el)
        break;
print(an)
