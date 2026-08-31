for _ in range(int(input())):
    lis=[0]*int(input())
    for i in range(len(lis)):
        x=list(map(int,input().split()))
        lis[i]=x
    if(len(lis))==1:
        if lis[0][0]>=lis[0][1]:
            print("YES")
        else:
            print("NO")
    else:
        x=lis[0][0]
        y=lis[0][1]
        z=x-y
        if(z<0):
            print("NO")
        else:
            k=0
            for i in range(1,len(lis)):
                if(lis[i][0]<x or lis[i][1]<y):
                    k=1
                    print("NO")
                    break
                x=lis[i][0]
                y=lis[i][1]
                if(z>x-y):
                    k=1
                    print("NO")
                    break
                z=x-y
            if(k==0):
                print("YES")