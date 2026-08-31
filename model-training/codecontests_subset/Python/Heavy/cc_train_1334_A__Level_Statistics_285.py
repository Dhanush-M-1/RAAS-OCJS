T = int(input())
for _ in range(T):
    n = int(input())
    pairs = []
    pairsPossible = True 
    for i in range(n):
        p = [int(j) for j in input().split()]
        pairs.append(tuple(p))
    if pairs[0][0] - pairs[0][1] >= 0:
        for i in range(1, len(pairs)):
            if pairs[i][0] - pairs[i-1][0] < 0 or pairs[i][1] - pairs[i-1][1] < 0 or pairs[i][0] - pairs[i][1] < 0:
                pairsPossible = False
                break
            if (pairs[i][0] - pairs[i-1][0]) < (pairs[i][1] - pairs[i-1][1]):
                pairsPossible = False
                break
    else:
        pairsPossible = False
    if pairsPossible:
        print("YES")
    else:
        print("NO")
                
        