while True:
    n = int(input())
    if n == 0:
        break
    else:
        words = []
        for i in range(n):
            w = input()
            words.append(w)
        check = [5, 7, 5, 7, 7]
        flag = 0
        count = 1
        while True:
            w_len = 0
            for i in range(count-1, n):
                w_len += len(words[i])
                if w_len == check[flag]:
                    flag += 1
                    w_len = 0
                elif w_len > check[flag]:
                    flag = 0
                    break
                if flag == 5:
                    print(count)
                    break
            if flag == 5:
                break
            else:
                count += 1

