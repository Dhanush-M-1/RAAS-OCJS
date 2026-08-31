def check(word):
    l = 0
    step = 0
    for w in word:
        l += len(w)
        if step == 0 or step == 2:
            if l == 5:
                step += 1
                l = 0
            elif l > 5:
                return False
        elif step == 1 or step == 3:
            if l == 7:
                step += 1
                l = 0
            elif l > 7:
                return False
        elif step == 4:
            if l == 7:
                return True
    return False


while 1:
    n = int(input())
    if n == 0:
        break

    word = []
    for _ in range(n):
        word.append(input())

    cnt = 0
    while word != []:
        cnt += 1
        if check(word):
            break
        word.pop(0)

    print(cnt)

