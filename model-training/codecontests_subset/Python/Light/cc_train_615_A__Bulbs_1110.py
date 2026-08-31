n,m= map(int, input().split())
a=[]
for i in range(n):
    a+= list(map(int, input().split()))[1:]
print('YES' if len(set(a))==m else 'NO')