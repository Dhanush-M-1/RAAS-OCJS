s=input()
n=int(input())
ans=0
flag1=0
flag2=0
for i in range(0,n):
    b=input()
    if b==s or b[::-1]==s:
        ans+=2
    else:
        if (flag1==0 and b[0]==s[1]):
            ans+=1
            flag1=1
        elif (flag2==0 and b[1]==s[0]):
            ans+=1
            flag2=1
if ans>=2:
    print("YES")
else:
    print("NO")