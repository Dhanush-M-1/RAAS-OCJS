N, M = map(int, input().split())

lst = [0] + [1] + [-1]*N
for i in range(M):
    lst[int(input())+1] = 0

for i in range(2, N+2):
    if lst[i] == -1:
        lst[i] = lst[i-1] + lst[i-2]

print (lst[N+1]%1000000007)