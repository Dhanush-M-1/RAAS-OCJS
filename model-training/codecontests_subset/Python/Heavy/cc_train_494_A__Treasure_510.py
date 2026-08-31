s=input()
x=0
tf=True
c1=0
c2=0
for i in range(len(s)):
    if s[i]=='(':
        c1+=1
        x+=1
    else:
        x-=1
    if x<0:
        tf=False
        break
    if s[i]=='#':
        c2+=1
        ind=i
if tf:
    x=0
    ls=len(s)
    for i in range(len(s)):
        if s[i]=='(':
            x+=1
        else:
            x-=1
        if i==ind:
            x-=(2*c1-ls)
        if x<0:
            tf=False
            break
    if tf:
        for _ in range(c2-1):
            print(1)
        print(1+2*c1-ls)
        
    else:
        print(-1)
else:
    print(-1)