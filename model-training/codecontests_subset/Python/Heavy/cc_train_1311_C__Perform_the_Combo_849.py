def main():
    t = int(input())

    for _ in range(t):
        n, m = list(map(int, input().strip().split()))
        s = input()
        p = list(map(int, input().strip().split()))
        p.append(n)

        cnt = [[0 for _ in range(26)] for _ in range(n)]

        cnt[0][ord(s[0])-97] = 1

        for i in range(1, n):
            for j in range(26): cnt[i][j] = cnt[i-1][j]

            cnt[i][ord(s[i])-97] += 1

        ret = [0 for _ in range(26)]

        for pos in p:
            for i in range(26): ret[i] += cnt[pos-1][i]



        print(" ".join(list(map(str, ret))))



if __name__ == "__main__": main()