a=int(input())
l=input();c=0
m=len(l);flag=0
for i in l:
    if i=='8':
        flag=1
        c+=1
n=m//11
if flag==1:
    print(min(n,c))
else:
    print(0)