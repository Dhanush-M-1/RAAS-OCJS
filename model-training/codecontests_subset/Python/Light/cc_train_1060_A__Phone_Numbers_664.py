n=int(input())
s=input()
c=0
for i in range(n):
    if s[i]=='8':
        c+=1
print(min(c,len(s)//11))
