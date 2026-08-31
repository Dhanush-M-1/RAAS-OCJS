n,k=map(int,input().split())
t10=[]
t01=[]
t11=[]

for x in range(n):
    t,a,b=map(int,input().split())
    if a==0 and b==1:
        t01.append(t)
    elif a==1 and b==0:
        t10.append(t)
    elif a==1 and b==1:
        t11.append(t)
t10.sort()
t01.sort()
t11.sort()
for x in range(1,len(t01)):
    t01[x]+=t01[x-1]
for x in range(1,len(t10)):
    t10[x]+=t10[x-1]
for x in range(1,len(t11)):
    t11[x]+=t11[x-1]

t10=[0]+t10
t01=[0]+t01
t11=[0]+t11
ans=[]

for x in range(len(t11)):
    if (k-x)>(len(t10)-1) or (k-x)>(len(t01)-1):
        continue
    t=0
    t+=t11[x]
    t+=t01[k-x]
    t+=t10[k-x]
    ans.append(t)
    if x==k:
        break

if len(ans)==0:
    print(-1)
else:
    print(min(ans))
















    
