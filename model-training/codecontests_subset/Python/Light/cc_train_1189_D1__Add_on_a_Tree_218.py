a = int(input())
A = [0]*a
k=0
for i in range(a-1):
    q,w = map(int,input().split())
    A[q-1]+=1
    if A[q-1]==2:
        k+=1
    elif A[q-1]==3:
        k-=1
    A[w-1]+=1
    if A[w-1]==2:
        k+=1
    elif A[w-1]==3:
        k-=1   
if k == 0:
    print('YES')
else:
    print('NO')