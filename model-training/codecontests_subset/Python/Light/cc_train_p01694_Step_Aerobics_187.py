while True:
    n = int(input())
    if n == 0: break
    ans = 0
    f = input().split()
    for i in range(len(f) - 1):
        if f[i] == "lu" and f[i+1] == "ru" \
                or f[i] == "ru" and f[i+1] == "lu" \
                or f[i] == "ld" and f[i+1] == "rd" \
                or f[i] == "rd" and f[i+1] == "ld":
                    ans += 1
    print(ans)