def answer(s, mistakes) :
    lettArr = [0] * 26
    comboCountArr = [1] * len(s)
    stack = 0
    for m in mistakes :
        comboCountArr[m-1] += 1

    for i in range(len(comboCountArr)-1, -1, -1) :
        comboCountArr[i] += stack

        if comboCountArr[i] > 1 and i != 0 :
            stack = (comboCountArr[i]-1)
        
    dic = {
        'a' : 0, 'b' : 1, 'c' : 2, 'd' : 3, 'e' : 4,
        'f' : 5, 'g' : 6, 'h' : 7, 'i' : 8, 'j' : 9,
        'k' : 10, 'l' : 11, 'm' : 12, 'n' : 13, 'o' : 14,
        'p' : 15, 'q' : 16, 'r' : 17, 's' : 18, 't' : 19,
        'u' : 20, 'v' : 21, 'w' : 22, 'x' : 23, 'y' : 24, 'z' : 25
    }
    for i in range(len(s)) :
        lettArr[dic[s[i]]] += comboCountArr[i]

    return " ".join([str(c) for c in lettArr])

testCount = int(input())
for _ in range(testCount) :
    n, m = map(int, input().split())
    s = input()
    p = list(map(int, input().split()))
    print(answer(s.rstrip(), p))