def main():
    t = int(input())
    for query in range(t):
        N, M = (int(i) for i in input().split())
        T = input()
        P = [int(i) for i in input().split()]
        al = {chr(ord('a') + i): 0 for i in range(26)}
        s = [0] * N  # 0-indexed
        for p in P:
            s[0] += 1
            s[p] -= 1
        S = [0] * (N+1)
        for i in range(N):
            S[i+1] = S[i] + s[i]
        for i in range(1, N+1):
            al[T[i-1]] += S[i]
        for st in T:
            al[st] += 1
        print(*al.values())


if __name__ == '__main__':
    main()
