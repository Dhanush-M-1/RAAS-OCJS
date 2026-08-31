n, k = [int(s) for s in input().split(" ")]
A = [int(s) for s in input().split(" ")]
divs = [0]*len(A)
maximum = max(A)
ans = float('inf')
while maximum > 0:
    if A.count(max(A)) >= k:
        D = [divs[i] for i in range(len(A)) if A[i] == maximum]
        D.sort()
        ans = min (ans, sum(D[:k]))
    max_index = A.index(max(A))
    A[max_index] = int(A[max_index] / 2 )
    maximum = max(A)
    divs[max_index] += 1
D = [divs[i] for i in range(len(A)) if A[i] == maximum]
D.sort()
ans = min (ans, sum(D[:k]))
print(ans)