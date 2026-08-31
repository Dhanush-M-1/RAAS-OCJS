n,m=map(int,input().split())
p=(m*(m+1))//2
l=[]
for i in range(n):
    l += list(map(int, input().split()))[1:]
print('YES' if len(set(l)) == m else 'NO')