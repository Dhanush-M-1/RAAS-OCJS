n,m=map(int,input().split())
x=set()
for i in range(n):
    l = list(map(int,input().split()))
    x=set(list(x)+l[1:])
print(["NO", "YES"][len(x)==m])