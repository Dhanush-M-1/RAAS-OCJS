p = input();t=0;d=0;e=0;f=0
for j in range(int(input())):
    t = input()
    if t[1]==p[0]:
        d=1
    if t[0]==p[1]:
        e=1
    elif t==p:
        f=1
if (d==1 and e==1) or f==1:
    print("YES")
else:
    print("NO")
        
