x=int(input())
if(x<11):
    y=input()
    print(0)
else:
    x=x//11
    y=input()
    Y=len(y)
    N=0
    for k in range (0,Y):
        if(y[k]=="8"):
            N+=1
    if(N>=x):
        print(x)
    else:
        print(N)
