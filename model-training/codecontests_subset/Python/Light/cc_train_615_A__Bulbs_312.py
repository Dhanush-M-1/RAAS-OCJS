q=input()
n=int(q.split(" ")[0])
m=int(q.split(" ")[1])
swm=set()
i=1
for num in range(0,n):
    k=input().split(' ')
    del(k[0])
    for x in k:
        swm.add(x)
if len(swm)<m:
    print("NO")
else:
    print("YES")