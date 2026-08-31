n,m=map(int,input().split())
s=[]
for i in range(n):
    w=input().split()
    s+=w[1:]
s1={str(x) for x in range(1,m+1)}
print('YES' if set(s)==s1 else 'NO')