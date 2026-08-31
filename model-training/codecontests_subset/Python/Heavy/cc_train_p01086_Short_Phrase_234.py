p = [5, 7, 5, 7, 7]
while True:
    n = int(input())
    if n == 0:
        break
    word = [input() for _ in range(n)]
    flag = False
    for i in range(len(word)):
        ip = 0
        phrase = ["" for _ in range(len(p))]
        if flag:
            break
        for j in range(i, len(word)):
            if len(phrase[ip]+word[j]) == p[ip]:
                phrase[ip] += word[j]
                ip += 1
            else:
                phrase[ip] += word[j]
                if len(phrase[ip]) > p[ip]:
                    break
                if len(phrase[ip]) == p[ip]:
                    ip += 1
            if len(phrase[-1]) == 7:
                print(i+1)
                flag = True
                break


