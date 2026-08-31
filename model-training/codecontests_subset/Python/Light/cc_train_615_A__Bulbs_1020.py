q=list(map(int,input().split()))
w=[True]+[False for i in range(0,q[1])]
for i in range(0,q[0]):
    e=list(map(int,input().split()))
    r=e.pop(0)
    for j in e:
        w[j]=True
if w.count(True)==q[1]+1:
    print('YES')
else:
    print('NO')