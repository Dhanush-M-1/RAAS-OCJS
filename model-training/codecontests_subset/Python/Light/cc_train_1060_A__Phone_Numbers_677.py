n=int(input())
s=input()
c=0
for i in range(n):
    if(s[i]=='8'):
        c=c+1
if(c>=(n//11)):
    print(n//11)
else:
    print(c)
