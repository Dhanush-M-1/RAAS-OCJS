def divisors(n):
    m = int(n**0.5) + 1
    divisors = [n]
    for i in range(2, m):
        if n%i == 0:
            divisors.append(i)
            if n//i != i:
                divisors.append(n//i)
    return divisors


l, r = map(int, input().split())
if r-l > 10:
    print(2)
else:
    dic = {}
    for i in range(l, r+1):
        tmp = divisors(i)
        for j in tmp:
            dic[j] = dic.get(j, 0) + 1

    count = -1
    ans = -1
    for i in dic.keys():
        val = dic[i]
        if val > count:
            count = val
            ans = i

    print(ans)

