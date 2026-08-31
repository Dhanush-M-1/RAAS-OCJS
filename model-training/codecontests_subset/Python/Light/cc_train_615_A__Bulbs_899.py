x=input().split()
y=[]
p=[]
flag=1
for i in range(int(x[0])):
    p=input().split()
    p.pop(0)
    y=y+p
y=list(dict.fromkeys(y))
for i in range(int(x[1])):
    if str(i+1) in y:
        continue
    else:
        print("NO")
        flag=0
        break
if flag==1:
    print("YES")
