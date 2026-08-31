ans=input()
a=[]
b=[]
n=int(input())
k=False
for i in range(n):
    temp=input()
    if temp==ans:
        k=True
    else:
        a.append(temp[0])
        b.append(temp[1])

if ans[0] in b:
    if ans[1] in a:
        k=True
if k:
    print("YES")
else:
    print("NO")