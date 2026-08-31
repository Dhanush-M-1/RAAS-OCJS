for z in range (int(input())):
    n=int(input())
    s=input()
    a=[]
    c1=0
    c2=0
    for i in range (n):
        if(s[i]=='>'):
            a.append(0)
        else:
            a.append(1)


    if(a[0]==0 or a[n-1]==1):
        print(0)

    
    elif(a[0]==1 and a[n-1]==0):
        ans=99999999
        for i in range (n-1):
            if(a[i]==1 and a[i+1]==0):
                ans=min(ans,i+1,(n-i-1))

            elif(a[i]==0 and a[i+1]==1):
                ans=min(ans,i+1,(n-i-1))
        print(ans)