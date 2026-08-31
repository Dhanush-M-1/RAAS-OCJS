n,k1 = map(int,input().split())

A = []
B = []
AB = []

for i in range(n):
    t,a,b = map(int,input().split())

    if a==1 and b==1:
        AB.append(t)

    elif a==1:
        A.append(t)

    elif b==1:
        B.append(t)

AB.sort()
A.sort()
B.sort()

if len(AB) + len(A) >=k1 and len(AB) + len(B) >=k1:
    a = 0
    b = 0
    i = 0
    j = 0
    k = 0
    ans = 0
    books = 0
    while i < len(A) and j<len(B) and k < len(AB):
        if A[i] + B[j] <= AB[k] :
            ans += A[i]+B[j]
            i+=1
            j+=1
            
            books +=1
        else:
            ans += AB[k]
            k+=1
            books+=1

        if books == k1 :
            break

    if i >= len(A) and books!=k1:
        ans += sum(AB[k:k+k1-books])

    elif j>= len(B) and books != k1:
        ans += sum(AB[k:k+k1-books])

    elif k >= len(AB) and books!=k1:
        ans += sum(A[i:i+k1-books]) + sum(B[j:j+k1-books])

    print(ans)

else:
    print(-1)