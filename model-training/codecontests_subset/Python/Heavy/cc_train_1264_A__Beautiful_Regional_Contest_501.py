a=int(input())
for i in range(a):
    r=int(input())
    z=list(map(int,input().split()))
    flag=0
    ans=[0]
    ans[0]=1
    if(len(z)<10):
        print(0,0,0)
        continue;
    count=0
    g=1
    s=0
    b=0
    gold=0
    change=0
    for i in range(1,(len(z)//2)):
        if(z[i]==z[i-1] and g==1):
            ans.append(1)
        elif(z[i]==z[i-1] and s==1):
            ans.append(2)
        elif(z[i]==z[i-1] and b==1):
            ans.append(3)
        else:
            change=i
            count+=1
            if(count==1):
                gold=i
                ans.append(2)
                g=0
                s=1
            else:
                if(i-gold>gold):
                    g=0
                    s=0
                    b=1
                    ans.append(3)
                else:
                    ans.append(2)
                    

    if(z[len(z)//2]==z[change]):
        ans=ans[0:change]
        
    
    
    if(ans.count(1)<ans.count(2) and ans.count(1)<ans.count(3)):
        print(ans.count(1),ans.count(2),ans.count(3))
    else:
        print(0,0,0)
        
        
        
        
        
