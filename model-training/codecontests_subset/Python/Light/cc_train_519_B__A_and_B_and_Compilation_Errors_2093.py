n=int(input())
A=list(map(int,input().split()))
B=list(map(int,input().split()))
C=list(map(int,input().split()))
D={}
for val in A:
    if val in D:
        D[val] = D[val] + 1
    else:
        D[val] = 1
T=dict(D)
for val in B:
    if val in T:
        T[val] = T[val] -  1
        if T[val] == 0:
            T.pop(val)
for val in T:
    if val in D:
        D[val] -= 1
        print(val)
        if D[val] == 0:
            D.pop(val)
for val in C:
    if val in D:
        D[val] -=  1
        if D[val] == 0:
            D.pop(val)
for val in D:
    print(val)

