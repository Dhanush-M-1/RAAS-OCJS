a,b=map(int,input().split())
s=set([0])
for i in range(a):
    l=list(map(int,input().split()))
    s=set(list(s)+l[1:])
print(["NO","YES"][(len(s)-1)==b])