n=int(input())

l  = input()
v={}
for i in l.split():
    if i in v:v[i]+=1
    else:v[i]=1
l  = input()
x={}
for i in l.split():
    if i not in v:
        print(i)
    else :
        v[i]-=1
    if i in x:x[i]+=1
    else:x[i]=1
    
for i in v:
    if v[i]==1:
        print(i)
l  = input()

for i in l.split():
    if i not in x:
        print(i)
    else :
        x[i]-=1

    
for i in x:
    if x[i]==1:
        print(i)

