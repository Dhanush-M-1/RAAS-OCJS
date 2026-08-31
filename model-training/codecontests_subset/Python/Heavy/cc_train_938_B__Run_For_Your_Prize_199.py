N = int(input())
A = [int(x) for x in input().split()]

# A.sort()
# print(A)

# print([(A[i] - 1) + (10**6 - A[i+1] - 1) for i in range(0,N-1)])
# print(A[N-1] - 1)
# print(10**6 - A[0])

# pos = [(A[i] - 1) + (10**6 - A[i+1] - 1) for i in range(0,N-1)]
# pos.append(A[N-1] - 1)
# pos.append(10**6 - A[0] - 1)
# print(pos)
# print(min(pos))

for i in range(len(A)):
    if A[i] > 10**6 // 2:
        A[i] = 10**6 - A[i] + 1
# print(A)
print(max(A) - 1)

# print(min([abs(i-(N//2)) for i in range(N)]))
