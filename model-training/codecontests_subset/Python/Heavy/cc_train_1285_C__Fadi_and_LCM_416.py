N = int(input())
M = N
A = []
flag = True
while flag == True:
    flag = False
    for i in range(2,int(N**0.5)+1):
        if N%i == 0:
            hoge = i
            while N%hoge == 0:
                hoge *= i
            A.append(hoge//i)
            N //= (hoge//i)
            flag = True
            break
A.append(N)
ans = M
for i in range(2**len(A)):
    hoge = 1
    for j in range(len(A)):
        if i & 1 == 1:
            hoge *= A[j]
        i >>= 1
    ans = min(ans,max(M//hoge,hoge))
print(ans,M//ans)