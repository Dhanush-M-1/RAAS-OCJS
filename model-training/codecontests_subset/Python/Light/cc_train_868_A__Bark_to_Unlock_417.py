p=input()
n=int(input())
lf=0
rf=0
ans="NO"
for i in range (n):
    a=input()
    if(a[0]==p[1]):
        lf=1
    if(a[1]==p[0]):
        rf=1
    if(p==a):
        ans="YES"
if(lf==1 and rf==1):
    ans="YES"
print(ans)
    

