def ans(n,A):
    if A[0]+A[1]>A[-1]:
        return [-1]
    else:
        return [1,2,n]


t=int(input())
L=[]
for i in range(t):
    n=int(input())
    A=[int(x) for x in input().split()]
    L.append(ans(n,A))

for l in L:
    for w in l:
        print(w,end=' ')
    print()