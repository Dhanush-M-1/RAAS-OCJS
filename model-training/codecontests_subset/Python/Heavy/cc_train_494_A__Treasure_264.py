s = list(input())
f=b=c=0;l=len(s);ans=[]
for i in range(l):
    if s[i]=="(":
        f+=1
    else:
        b+=1
        if s[i]=='#':
            ans.append(1)
    if b>f:
        print(-1)
        exit()
ans[-1]+=(f-b)
b=f
#print(ans)
for i in range(l-1,-1,-1):
    if s[i]=="(":
        f-=1
    elif s[i]==")":
        b-=1
    else:
#        print(b,f)
        if b>f:
            print(-1)
            exit()
        for j in range(i+1,l):
            if s[j]=="(":
                f+=1
            else:
                b+=1
#            print(f,b,i,s[j])    
            if b>f:
                print(-1)
                exit()        
        break    
for i in ans:
    print(i)             