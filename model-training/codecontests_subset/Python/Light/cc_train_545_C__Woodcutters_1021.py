ans=2
I=lambda:list(map(int,input().split()))
l=[]
for tc in range(int(input())):
    x,h=map(int,input().split())
    l.append([x,h])
t=l[0][0]
n=len(l)
if n<=2:
    print(n)
    exit()
for i in range(1,n-1):
    x,h=l[i]
    if x-h>t:
        ans+=1
        t=x
    elif x+h<l[i+1][0]:
        ans+=1
        t=x+h
    else:
        t=x
print(ans)