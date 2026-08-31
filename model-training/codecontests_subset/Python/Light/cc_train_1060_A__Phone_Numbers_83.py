n=int(input())
s=input()
m=n//11
c=0

for i in range(n):
    if(s[i]=='8'):
        c+=1

print(min(m,c))
