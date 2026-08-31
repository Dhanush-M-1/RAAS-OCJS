def solve():
    n = int(input())
    g = s = b = 0
    arr = [int(a) for a in input().split(" ")]
    sum = {}
    for a in arr:
        sum[a] = sum.get(a, 0) + 1
    vals = list(sum.values())
    half = n // 2
    if n < 3:
        return "0 0 0"
    g = vals[0]
    if g+s+b > half:
        return "0 0 0"
    for i in range(1, len(vals)):
        if g+s+b+vals[i] <= half:
            if g >= s:
                s+=vals[i]
            else:
                b+=vals[i]
        else:
            break
    if g>=s or g>=b:
        return "0 0 0"
    return f"{g} {s} {b}"


t = int(input())
for i in range(t):
    print(solve())
