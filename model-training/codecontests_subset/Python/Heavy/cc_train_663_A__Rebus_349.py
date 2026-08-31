from sys import stdin
s=stdin.readline().strip().split()

def smas(x,mas):
    for i in range(len(s)):
        if s[i]==1 and (i==0 or s[i-1]=="+"):
            if x>0:
                y=min(n-1,x)
                s[i]+=y
                x-=y
def smen(x,men):
    for i in range(len(s)):
        if s[i]==1 and i>0 and s[i-1]=="-":
            if x>0:
                y=min(n-1,x)
                s[i]+=y
                x-=y
n=int(s[-1])
ans=0
y=0
if s[0]=="-":
    y=1
ind=-1
men=0
mas=0
for i in range(y,len(s)-1,2):
    if i!=0 and s[i-1]=="-" :
        ans-=1
        men+=1
    else:
        mas+=1
        if ind==-1:
            ind=i
        else:
            ans+=1
    s[i]=1
l=[-(n*men),-men]
t=True
for i in range(mas,n*mas+1):
    if i>=n:
        x=n-i
    else:
        continue

    if x>=l[0] and x<=l[1]:
        t=False
        smas(i-mas,mas)
        smen((-x)-men,men)
        break

if t:
    print("Impossible")
else:
    print("Possible")
    print(*s)
