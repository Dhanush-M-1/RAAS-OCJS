t=int(input())
for g in range(0,t):
    a=list(map(str,input().split()))
    inp=a[0]
    c=a[1]
    s=[]
    for i in range(0,len(inp)):
        s.append(inp[i])
    n=len(s)
    swap=0
    for i in range(0,n):
        if(s[i]=="A"):
            continue
        else:
            temp=s[i]
            for j in range(i+1,n):
                if(temp>s[j]):
                    temp=s[j]
            if(temp!=s[i]):
                for j in range(n-1,i-1,-1):
                    if(s[j]==temp):
                        break
                s[i],s[j]=s[j],s[i]
                swap=1
        if(swap==1):
            break;
    ans=""
    for i in range(0,n):
        ans+=s[i]
    if(ans<c):
        print(ans)
    else:
        print("---")