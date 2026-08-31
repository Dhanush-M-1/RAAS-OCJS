a,b=input().split()
a=int(a)
b=int(b)
cnt=0
rem=0
while a!=0:
    rem=rem+a%b
    if rem>=b:
        cnt+=rem//b
        rem=rem%b+rem//b
    cnt+=a
    a//=b
print(cnt)