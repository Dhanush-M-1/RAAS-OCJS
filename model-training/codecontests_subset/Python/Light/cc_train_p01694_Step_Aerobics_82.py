def main():
    N = int(input())
    answer = []
    while N != 0:
        cmd = [i for i in input().split()]
        ans = 0
        g_flag = True
        p = ["ld", "rd"]
        for c in cmd:
            if c[0] == "l":
                p[0] = c
            else:
                p[1] = c
            if g_flag and p[0] == "lu" and p[1] == "ru":
                g_flag = False
                ans += 1
            if not g_flag and p[0] == "ld" and p[1] == "rd":
                g_flag = True
                ans += 1
        answer.append(ans)
        N = int(input())
    print(*answer,sep="\n")


if __name__ == '__main__':
    main()

