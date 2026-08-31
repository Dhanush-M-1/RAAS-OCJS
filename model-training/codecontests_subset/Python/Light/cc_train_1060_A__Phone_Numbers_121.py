a=int(input())
b=input()
n=a//11
c=0
for i in range(a):
    if(b[i]=='8'):
        c+=1
print(min(c,n))
