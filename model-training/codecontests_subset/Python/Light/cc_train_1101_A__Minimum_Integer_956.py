n=int(input(''))
for x in range(0,n):
    x=list(map(int,input().split()))
    if x[2]<x[0]:
        x[2]=x[2]
     
    elif x[2]>x[1]:
        x[2]=x[2]
     
    else:
        x[2]=x[2]*(x[1]//x[2]+1)
        
    print(x[2])
    

