n=int(input())
x=input()
c=0
for i in range(n):
    if(x[i]=='8'):
        c+=1
print(min(c,n//11))