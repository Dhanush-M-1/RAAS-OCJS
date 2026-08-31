s=input()
n=int(input())
a=[]
for i in range(n):
    a.append(input())
t=0

if s in a :
    print("YES")
else:
    for i in range(n):
        if a[i][1]==s[0]:
            for j in range(0,n):
                if a[j][0]==s[1]:
                    t=1
            break
    if t==1:
        print("YES")
    else:
        print("NO")
