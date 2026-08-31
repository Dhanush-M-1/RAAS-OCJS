a,b=input().split()
a,b=int(a),int(b)
C=[]
for i in range(a):
    c=input().split()
    for i in range(int(c[0])):
        if c[i+1] not in C:
            C.append(c[i+1])
if b==len(C):
    print('YES')
else:
    print('NO')