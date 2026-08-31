n,m=input().split()
k=int(input())
l=[]
l.append([n,m])
for _ in range(k):
    a,b=input().split()
    if a==n:
        n=b
    elif a==m:
        m=b
    l.append([n,m])
for i in l:
    print(*i)
    
