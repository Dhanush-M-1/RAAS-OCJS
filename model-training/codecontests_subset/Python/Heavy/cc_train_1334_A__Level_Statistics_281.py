t=int(input())
for i in range(t):
    n=int(input())
    x=[]
    for j in range(n):
        a,b=input().strip().split(" ")
        a,b=[int(a),int(b)]
        x.append([a,b])
    ff=1
    
    if x[0][0]<x[0][1]:
        ff=0
    for j in range(n-1):
        k=x[j+1][0]-x[j][0]
        if k<0:
            ff=0
            break
        elif (x[j+1][1]-x[j][1]<0):
            ff=0
            break
        elif (x[j+1][1]-x[j][1]>k):
            ff=0
            break
        
    if ff:
        print("YES")
    else:
        print("NO")
