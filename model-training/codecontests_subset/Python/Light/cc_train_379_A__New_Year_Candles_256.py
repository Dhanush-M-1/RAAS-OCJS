s=input()
s=s.split()
a=int(s[0])
b=int(s[1])
rem=a
ans=a
while rem>0:
    if rem<b:
        break
    ans+=rem//b
    rem=rem//b+rem%b
print(ans)