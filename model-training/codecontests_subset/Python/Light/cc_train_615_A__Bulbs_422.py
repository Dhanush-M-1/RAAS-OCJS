list=[]

n,m=input().split(' ')
n=int(n)
for i in range(0,n):
    x=input().split(" ")
    x.pop(0)
    for xi in x:
        if int(xi) not in list:
            list.append(int(xi))
            
            
found=False
m=int(m)
for i in range (0,m):
    if int(i)+1 not in list:
        print('NO')
        found=True
        break

if not found:
    print('YES')