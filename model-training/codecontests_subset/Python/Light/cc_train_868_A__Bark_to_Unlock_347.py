s=input()
n=int(input())
l=[]
for i in range(n):
    l.append(input())
r=s[1]+s[0]
f=0
if(s in l or r in l):
    print("YES")
else:
    x,y=0,0
    for i in range(n):
        if(l[i][1]==s[0]):
            x=1
        if(l[i][0]==s[1]):
            y=1
    if(x==1 and y==1):
        print("YES")
    else:
        print("NO")
