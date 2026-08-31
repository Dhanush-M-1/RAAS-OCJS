from collections import Counter

def get_exes(a, mx, m):
    exes = set()

    for num in a:
        if num != mx:
            if mx > num:
                exes.add(mx-num)
            else:
                exes.add(m-num+mx)
        else:
            exes.add(0)

    
    return exes

def solve(a, b, m):
    counts_b = Counter(b)

    exes = get_exes(a, max(b), m)

    for x in sorted(list(exes)):
        counts_a = Counter([(num+x) % m for num in a])

        if counts_a == counts_b:
            return x

n, m = list(map(int, input().strip().split(" ")))
a = list(map(int, input().strip().split(" ")))
b = list(map(int, input().strip().split(" ")))
print(solve(a, b, m))

