n=int(input())
a=list(map(int,input().split()))
b=list(map(int,input().split()))
c=list(map(int,input().split()))
a1={}
b1={}
c1={}
for i in a:
    if i in a1:
        a1[i]+=1
    else:
        a1[i]=1
for i in b:
    if i in b1:
        b1[i]+=1
    else:
        b1[i]=1
for i in c:
    if i in c1:
        c1[i]+=1
    else:
        c1[i]=1
for i in a1:
    if i not in b1:
        print(i)
        break
    if b1[i]!=a1[i]:
        print(i)
        break
for i in b1:
    if i not in c1:
        print(i)
        break
    if c1[i]!=b1[i]:
        print(i)
        break
