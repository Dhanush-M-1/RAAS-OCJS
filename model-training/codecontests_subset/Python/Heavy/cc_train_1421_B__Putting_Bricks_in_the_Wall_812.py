for _ in range(int(input())):
    n=int(input())
    l=[]
    for i in range(n):
        s=input()
        k=list(s)
        l.append(k)
    c=0
    v1=l[0][1]
    v2=l[1][0]
    v3=l[n-1][n-2]
    v4=l[n-2][n-1]
    ans=[]
    if(v1==v2):
        if(v1=='1'):
            if(v3=='1'):
                c+=1
                ans.append(n-1)
                ans.append(n-2)
            if(v4=='1'):
                c+=1
                ans.append(n-2)
                ans.append(n-1)
        else:
            if (v3 == '0'):
                c += 1
                ans.append(n - 1)
                ans.append(n - 2)
            if (v4 == '0'):
                c += 1
                ans.append(n - 2)
                ans.append(n - 1)
    elif(v3==v4):
        if (v3 == '1'):
            if (v1 == '1'):
                c += 1
                ans.append(0)
                ans.append(1)
            if (v2 == '1'):
                c += 1
                ans.append(1)
                ans.append(0)
        else:
            if (v1 == '0'):
                c += 1
                ans.append(0)
                ans.append(1)
            if (v2 == '0'):
                c += 1
                ans.append(1)
                ans.append(0)
    else:
        if(v1=='0'):
            c+=1
            ans.append(0)
            ans.append(1)
        elif v2=='0':
            c+=1
            ans.append(1)
            ans.append(0)
        if(v3=='1'):
            c+=1
            ans.append(n-1)
            ans.append(n-2)
        elif v4=='1':
            c+=1
            ans.append(n-2)
            ans.append(n-1)
    print(c)
    if(c>0):
        print(ans[0]+1,ans[1]+1)
    if(c>1):
        print(ans[2]+1,ans[3]+1)
