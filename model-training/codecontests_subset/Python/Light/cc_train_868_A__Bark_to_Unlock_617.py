k=input()
sol=[]
flag=False
for _ in range(int(input())):
    x=input()
    sol.append(x)
for i in range(len(sol)):
    for j in range(len(sol)):
        if k in (sol[i]+sol[j])*3 or k in (sol[j]+sol[i])*3:
            flag=True
            break
    if flag==True:
        break
if flag:
    print("YES")
else:
    print("NO")
