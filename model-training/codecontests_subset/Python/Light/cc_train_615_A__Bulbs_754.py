n,m=map(int,input().split())
a=(m*(m+1))//2
li=[]
for i in range(n):
    li += list(map(int, input().split()))[1:]
print('YES' if len(set(li)) == m else 'NO')