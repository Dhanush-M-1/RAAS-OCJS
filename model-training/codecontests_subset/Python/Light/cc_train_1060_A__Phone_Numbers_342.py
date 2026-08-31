n=int(input())
x=input()
c=0
for i in x:
    if i=="8":
        c+=1
if n//11>=c and c!=0:
    print(c)
elif n//11<c and c!=0:
    print(n//11)
else:
    print(0)
