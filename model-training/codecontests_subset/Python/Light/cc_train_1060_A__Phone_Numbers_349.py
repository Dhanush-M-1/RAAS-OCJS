n=int(input())
c=0
x=input()
for i in range(len(x)):
    if x[i]=='8':
        c+=1
if c==0:print(0)
else:
    a=[n//11,c]
    print(min(a))