t = int(input())
while t != 0:
    t -= 1
    n = input().split(" ")
    n = list(map(int, n))
    a, b = n
    s = input()
    m = input().split(" ")
    m = list(map(int, m))
    dic = {chr(x): 0 for x in range(ord('a'), ord('{'))}
    mistake = []
    for x in range(a):
        mistake.append(0)
    for x in m:
        mistake[x-1] += 1
        # print(f" {x-1} soy el error {mistake[x-1]}")
    err = 1
    for x in range(1,a+1):
        if mistake[-x] != 0:
            err += mistake[-x]
        mistake[-x] = max(err, mistake[-x])
        # print(mistake[-x])
    for x in range(a):
        dic[s[x]] += mistake[x]
    r = ""
    for d in dic:
        r += str(dic[d])
        r += " "
    print(r)






