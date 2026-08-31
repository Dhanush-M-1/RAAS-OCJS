a,b=map(int,input().split())
list=[]
for i in range(a):
    d=input().split()
    for j in range(int(d[0])):
        list.append(d[j+1])
if len(set(list))==b:
    print('YES')
else:
    print('NO')