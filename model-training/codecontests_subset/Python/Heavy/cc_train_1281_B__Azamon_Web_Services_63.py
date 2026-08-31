INT_MAX = 10 ** 10


def get_nse(nums):
    best = None, None
    ans = []
    for j in range(len(nums) - 1,  -1, -1):
        ans.append(best)
        if not best[0]:
            best = (a[j], j)
        else:
            if a[j] < best[0]:
                best = (a[j], j)
    ans.reverse()
    return ans


n = int(input())
while n:
    a = input().split()
    b = list(a[0])
    a = list(a[1])
    a, b = b, a

    nse = get_nse(a)
    i = 0
    used = False
    while i < len(b):
        
        if i >= len(a):
            break
        if a[i] < b[i]:
            break
        if not used and nse[i][0] and nse[i][0] < b[i]:
            a[i], a[nse[i][1]] = a[nse[i][1]], a[i]
            break
        if not used and nse[i][0] and nse[i][0] != a[i] and nse[i][0] == b[i]:
            a[i], a[nse[i][1]] = a[nse[i][1]], a[i]
            used = True
        elif b[i] < a[i]:
            a = ["-" for each in range(3)]
        i += 1
    if i == len(b):
        print("---")
    else:
        print("".join(a))


    n -= 1