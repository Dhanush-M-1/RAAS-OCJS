m,n=input().split()
m,n=int(m),int(n)
lst=[]
lst1=[]
for item in range(m):
    lst=[int(x) for x in input().split()]
    lst.pop(0)
    for i in lst:
        lst1.append(i)
for r in range(1,n+1):
    if r not in lst1:
        print('NO')
        break
else:
    print('YES')
    
