n=int(input())
ls=[]
s=0
p=0
q=0
for i in range (n,n-3,-1):
    x = list(map(int, input().split()))
    ls.append(x)
for a in ls[0]:
    s=s+a
for b in ls[1]:
    p=p+b
for c in ls[2]:
    q=q+c
print (s-p)
print (p-q)


