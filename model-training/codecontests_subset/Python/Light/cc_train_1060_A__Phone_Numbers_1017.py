n=int(input())
s=input()
c=0
for i in range(len(s)):
    if(s[i]=='8'):
        c=c+1
        

a=n//11
print(min(c,a))
