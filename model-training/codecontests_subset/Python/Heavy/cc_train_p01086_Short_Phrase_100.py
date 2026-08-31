"短句"
# 各単語を始まりとして57577が作れるかどうか
while True:
    n = int(input())
    if n == 0:
        break
    words = [str(input()) for _ in range(n)]

    tanku = [5, 7, 5, 7, 7]
    target = 0
    ans = 0
    for i in range(n):
        now_len = 0
        # print("i : ", i)
        for j in range(i, n):
            now_len += len(words[j])
            # print(words[j], now_len)

            if now_len == tanku[target]:
                now_len = 0
                target += 1
            elif now_len < tanku[target]:
                pass
            elif now_len > tanku[target]:
                target = 0
                break

            if target == 5:
                break
        if target == 5:
            ans = i
            break
    print(ans+1)

