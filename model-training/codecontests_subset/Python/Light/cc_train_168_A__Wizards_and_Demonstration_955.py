import math
def wizards(n,x,y):
    percent=math.ceil((n*y)/100)
    if(percent>x):
        return(percent-x)
    else:
        return(0)

n,x,y=list(map(int,input().split()))
result=wizards(n,x,y)
print(result)