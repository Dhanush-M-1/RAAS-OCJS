s=input().split()
k=[]
n=0
for i in range(int(s[0])):
    j=input().split()
    for o in range(1,int(j[0])+1):
        k.append(j[o])
for i in range(1,int(s[1])+1):
    for m in k:
        if m==str(i):
            n+=1
            break
if n==int(s[1]):
    print('YES')
else:
    print('NO')