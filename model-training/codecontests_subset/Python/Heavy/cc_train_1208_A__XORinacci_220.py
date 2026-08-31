T = int(input())
ans_arr = []
for _ in range(T):
    arr = list(map(int, input().split()))
    a, b, n = arr[0], arr[1], arr[2]
    def xor(n):
        if n == 0:
            return a
        elif n == 1:
            return b
        sm = a # for n - 2
        bg = b # for n - 1
        ans = sm ^ bg
        for i in range(2, n):
            sm = bg
            bg = ans
            ans = sm ^ bg
        return ans
    if n % 3 == 0:
        t = xor(3)
    if n % 3 == 1:
        t = xor(4)
    if n % 3 == 2:
        t = xor(5)
    ans_arr.append(t)
for el in ans_arr:
    print(el)