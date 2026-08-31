n,m=map(int,input().split());p=[]
for i in range(n):
    x=[int(x) for x in input().split()]
    p+=x[1::]
p=set(p)
print('NO' if len(p)!=m else "YES")
