q = int(input())
A = [0] * q
for i in range(q):
    A[i] = input().split(' ')
for i in range(q):
    if int(A[i][2]) < int(A[i][0]) or int(A[i][2]) > int(A[i][1]):
        print(A[i][2])
    else:
        k = int(A[i][1])//int(A[i][2])
        print((k + 1) * int(A[i][2]))
