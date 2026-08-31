n = int(input())
L = input().split()
M = []
for i in range(len(L)):
    L[i] = int(L[i])
    M.append(min(abs(L[i]-1),abs(L[i]-1000000)))
print(max(M))
