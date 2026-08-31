s=input();n=int(input());x=0;y=0;k='';pd=0
for i in range(0,n):
    k=input()
    if k==s:
        print('YES')
        pd=1
        break
    else:
        if k[0]==s[1]:
            x=1
        if k[1]==s[0]:
            y=1
    if x==1 and y==1:
        print('YES')
        pd=1
        break
if pd==0:
    print('NO')