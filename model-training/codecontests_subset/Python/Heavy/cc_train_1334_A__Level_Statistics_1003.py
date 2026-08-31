
t=int(input())
while(t):
    n=int(input())
    a=[]
    for _ in range(n):
        nk=[int(i) for i in input().split()]
        a.append(nk)
    flag=1
    if(a[0][0]>=a[0][1]):
        for i in range(1,n):
            p=a[i][0]-a[i-1][0]
            
            c=a[i][1]-a[i-1][1]
        
            
            if(a[i][0]>=a[i][1]):
                if(p>=c and p>=0 and c>=0):
                    flag=1
                else:
                    flag=0
                    break
            else:
                flag=0
                break
    else:
        flag=0
    if(flag==1):
        print("YES")
    else:
        print("NO")
        
    t-=1
              