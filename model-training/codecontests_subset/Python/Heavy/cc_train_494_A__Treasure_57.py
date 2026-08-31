s=input()
n=len(s)
a=0
ans=''
c=1
c1=s.count('#')
for i in range(n):
    if(s[i]=='#'):
        c4=i
        ans+=')'
    else:
        ans+=s[i]
for i in ans:
    if(i=='('):
        a+=1
    else:
        a-=1
    if(a<0):
        c=0
        break
if(c==0):
    print(-1)
else:
    c2=ans.count('(')
    c3=ans.count(')')
    ans=ans[:c4+1]+')'*(c2-c3)+ans[c4+1:]
    a=0
    for i in ans:
        if(i=='('):
            a+=1
        else:
            a-=1
        if(a<0):
            c=0
            break
    if(c==0 or a!=0):
        print(-1)
    else:
        for i in range(c1-1):
            print(1)
        print(c2-c3+1)