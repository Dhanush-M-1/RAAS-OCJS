def solve(s):
    return max(int(s[:i]) * int(s[i:]) for i in range(1, len(s)))

for _ in range(int(input())):
    s = input()
    cnt = 0
    while len(s) > 1:
        cnt += 1
        s = str(solve(s))
    print(cnt)
