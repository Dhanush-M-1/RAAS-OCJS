s=input().strip()
l=[]
n=int(input())
for x in range(n):
    l.append(input().strip())

present=False
for i in range(n):
    for j in range(n):
        if s in l[i]+l[j] or s in l[j]+l[i]:
            present=True

if present:
    print("YES")
else:
    print("NO")