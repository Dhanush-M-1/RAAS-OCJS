def factors(x):
    factors = []
    while x % 2 == 0:
        x /= 2
        factors.append(2)
    while x % 3 == 0:
         x /= 3
         factors.append(3)
    return int(x), factors
        

def solution():
    from collections import Counter
    t = int(input())
    ans = []
    while t:
        n = int(input())
        left, two_three = factors(n)
        if left != 1:
            ans.append(-1)
        else:
            f = Counter(two_three)
            two, three = f[2], f[3]
            remaining = three - two
            if remaining >= 0:
                ans.append(two + 2*remaining)
            else:
                ans.append(-1)
        t -= 1
    for a in ans:
        print(a)


solution()
