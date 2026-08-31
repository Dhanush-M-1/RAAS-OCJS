# cook your dish here
t=int(input())
for _ in range(t):
    n=int(input())
    k=[]
    for __ in range(n):
        k.append(list(map(int,input().split())))
    flag=1    
    for i in range(n):
        if i==0 and k[i][0]>=k[i][1]:
            pass
        elif (k[i-1][0]<=k[i][0] and k[i-1][1]<=k[i][1] and k[i][0]>=k[i][1]):
            if k[i][1]-k[i-1][1] <=  k[i][0]-k[i-1][0]:
                pass
            else:
                flag=0
                break
            
        else:
            flag=0
            break
    if flag==1:
        print("YES")
    else:
        print("NO")