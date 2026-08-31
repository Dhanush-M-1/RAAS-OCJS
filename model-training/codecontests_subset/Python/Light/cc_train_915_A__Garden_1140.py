nk, Segments = list(map(int,input().split())), sorted(list(map(int,input().split())))
n, k = nk[0], nk[1]
for i in range(n-1, -1, -1):
    if k % Segments[i] == 0:
        print(k // Segments[i])
        exit()