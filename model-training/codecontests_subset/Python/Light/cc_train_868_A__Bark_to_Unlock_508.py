n=input()
v=''
d=0
m=0
n1=int(input())
for i in range(n1):
    s=input()
    if(n[0]==s[1]):
        if(m==0):
            v+=s[1]
            m=m+1
    elif(n[1]==s[0]):
        if(d==0):
            v+=s[0]
            d=d+1
    if(n==s[::-1] or n==s):
        v=''
        v+=s[::-1]
if(v==n or v[::-1]==n or n in v):
    print('YES')
else:
    print('NO')
