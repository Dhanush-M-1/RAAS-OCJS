t=int(input())
while(t!=0):
    a=int(input())
    c=[]
    for i in range(0,a):
        c.append(list(map(int,input().split(" "))))
    if(a==1 and c[0][0]>=c[0][1]):
        print("YES")
    elif(a==1 or c[0][0]<c[0][1]):
        print("NO")
    else:
        w=0
        for i in range(1,a):
            e=abs(c[i][0]-c[i-1][0])
            f=abs(c[i][1]-c[i-1][1])
            if(c[i][0]>=c[i-1][0] and c[i][1]>=c[i-1][1] and c[i][1]<=c[i][0] and f<=e):
                w=w+1
                continue
            else:
                print("NO")
                break
        if(w==a-1):
            print("YES")       
    t=t-1