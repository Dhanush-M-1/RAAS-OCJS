def valid(s):
    if(not(s[2]==s[5]=='-')):
        return False
    for i in range(10):
        if(i==2 or i==5):
            continue
        if(s[i]=='-'):
            return False
    m=int(s[6:])
    if(m<2013 or m>2015):
        return False
    m=int(s[3:5])
    if(m<1 or m>12):
        return False
    d=int(s[0:2])
    if(d<1 or d>D[m-1]):
        return False
    return True

D=[31,28,31,30,31,30,31,31,30,31,30,31]


A={}

s=input()
x=s[0:10]
if(valid(x)):
    A[x]=1
for i in range(10,len(s)):
    x=x[1:]+s[i]
    if(valid(x)):
        if(x in A):
            A[x]+=1
        else:
            A[x]=1
maxx=0
ans=""
for item in A:
    if(A[item]>maxx):
        maxx=A[item]
        ans=item
print(ans)
