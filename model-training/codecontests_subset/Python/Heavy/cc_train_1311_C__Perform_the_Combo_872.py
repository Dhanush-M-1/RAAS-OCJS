T = int(input())

def solve():
    [N,M] = list(map(int,input().split()))
    S = input()
    P = list(map(int,input().split()))
    P = sorted(P)

    count = {}
    for i in range(26):
        count[chr(ord('a')+i)] = 0

    p_index = 0
    for i in range(N):
        while p_index < len(P) and P[p_index] <= i:
            p_index += 1
        count[S[i]] += (1 + (M - p_index))

    ans = []
    for i in range(26):
        ans.append(str(count[chr(ord('a')+i)]))

    return (" ".join(ans))


for _ in range(T):
    print(solve())
