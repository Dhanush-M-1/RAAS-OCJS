n = int(input())
ls1 = [int(i) for i in input().split()]
ls2 = [int(i) for i in input().split()]
ls3 = [int(i) for i in input().split()]

ls1.sort()
ls2.sort()
ls3.sort()
i = 0
j = 0
res = []
while(i<n-1):
    if ls1[i]!=ls2[i]:
        res.append(ls1[i])
        break
    i+=1
    j+=1
if len(res)==0:
    res.append(ls1[n-1])
i = 0
j = 0

while(i<n-2):
    if ls2[i]!=ls3[i]:
        res.append(ls2[i])
        break
    i+=1
    j+=1

for r in res:
    print(r)
if len(res)==1:
    print(ls2[n-2])