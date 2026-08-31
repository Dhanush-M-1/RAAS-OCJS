def solve():
    global B, K
    both = [b[0] for b in B if b[1] and b[2]]
    alice = sorted([b[0] for b in B if b[1] and not b[2]])
    bob = sorted([b[0] for b in B if b[2] and not b[1]])

    for i in range(min(len(alice), len(bob))):
        both.append(alice[i] + bob[i])
    
    if len(both) < K: return -1
    return sum(sorted(both)[:K])

if __name__ == '__main__':

    # for _ in range(int(input())):
    N, K = map(int, input().split())
    B = [tuple(map(int, input().split())) for _ in range(N)]

    sol = solve()
    print(sol)
