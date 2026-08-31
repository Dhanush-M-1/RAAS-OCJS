s=str(input())
n=int(input())
t=0
z=0
for i in range (n):
    a=str(input())
    if a==s:
        print("YES")
        break
    if a[1]==s[0] and t==0:
        t+=1
    if a[0]==s[1] and z==0:
        z+=1
    if z==1 and t==1:
        print("YES")
        break
else:
    print("NO")