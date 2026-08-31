a=input()
n=int(input())
l,r=0,0
c=0
for i in range(n):
    s=input()
    if(s==a):c+=1
    if(s[1]==a[0]):l+=1
    if (s[0] == a[1]): r += 1
if (r and l) or c:
    print('YES')
else:
    print('NO')
