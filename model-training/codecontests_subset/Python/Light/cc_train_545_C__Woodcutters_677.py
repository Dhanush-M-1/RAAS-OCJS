n=int(input())
t=[];d=[]
for i in range(n):
    s=[int(x) for x in input().split()]
    t.append(s[0]);d.append(s[1])
if n<=2:
    print(n)
else:
    p=2
    for i in range(n-2):
        if t[i+1]-t[i]>d[i+1]:
            p+=1
        else:
            if t[i+2]-t[i+1]>d[i+1]:
                p+=1
                t[i+1]+=d[i+1]
    print(p)