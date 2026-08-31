t = int(input())
for _ in range (t):
    n = int(input())
    arr = list(map(int,input().split()))
    n = n//2
    if n < 5:
        print(0, 0, 0)
        continue
    lengths = []
    j = 0
    for i in range (1, n):
        if arr[i] != arr[i-1]:
            lengths.append(i - j)
            j = i
    if arr[n] != arr[n-1]:
        lengths.append(n - j)
    if len(lengths) < 3:
        print(0, 0, 0)
        continue
    G = lengths[0]
    S = 0
    k = 1
    while S <= G and k < len(lengths):
        S += lengths[k]
        k += 1
    B = sum(lengths) - G -S
    if G < S and G < B:
        print(G, S, B)
    else:
        print(0, 0, 0)