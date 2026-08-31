R=lambda:map(int,input().split())
r,S=R()
c,C=R()
d,D=R()
A=[(c+d-S)/2,(r+C-d)/2,(S+c-d)/2,(d+C-r)/2]
for i in range(4):
    if A[i]!=int(A[i])or A[i]<1or A[i]>9or len(set(A))<4:
        print(-1)
        exit()
    else:A[i]=int(A[i])
print(A[0],A[1])
print(A[2],A[3])
