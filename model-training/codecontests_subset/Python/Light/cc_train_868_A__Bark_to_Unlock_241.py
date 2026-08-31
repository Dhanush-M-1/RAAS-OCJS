s=str(input())
n=int(input())
e=0
f=0
flag=0
for i in range(n):
    s1=str(input())
    if(n==1 and (s1[::-1]==s)):
        print('YES')
        flag=1
        break
    elif(s1[::-1]==s):
        print('YES')
        flag=1
        break
    elif(s1[-1]==s[0]):
        e=e+1
    elif(s1[0]==s[1]):
        f=f+1
    elif(s1==s):
        print('YES')
        flag=1
        break
if(flag==0):
    if(e>0 and f>0):
        print('YES')
    else:
        print('NO')