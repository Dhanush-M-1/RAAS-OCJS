password=input()
n=int(input());first=0;second=0
for i in range(n):
    x=input()
    if x[0]==password[0] and x[1]==password[1]:
        first=1;second=1
    elif x[0]==password[1]:
        second=1
    if x[1]==password[0]:
        first=1
    elif x[1]==password[1]:
        second=1
if first==1 and second==1:
    print("YES")
else:
    print("NO")