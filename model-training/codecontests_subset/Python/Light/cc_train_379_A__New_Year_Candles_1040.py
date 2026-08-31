a,b = map(int,input().split())
t=a
rem=0
while a/b!=0:
    new=int(a/b)
    rem=rem+a%b
    if rem/b>=1:
        a=new+int(rem/b)
        rem=rem%b
    else:
        a=new
    t=t+a
print(t)
