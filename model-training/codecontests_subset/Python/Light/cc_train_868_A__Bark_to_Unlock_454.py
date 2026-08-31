s=input()
n=int(input())
ll,lf,c,l,f=[],[],0,0,0
for i in range(n):
    j=input()
    if j==s or j==s[::-1]:
        c=1
    elif f==0 and j[0]==s[1]:
        lf.append(j)
        f=1
    elif l==0 and j[1]==s[0]:
        ll.append(j)
        l=1
if c==1:
    print("YES")
elif len(ll)>=1 and len(lf)>=1:
    print("YES")
else:
    print("NO")
