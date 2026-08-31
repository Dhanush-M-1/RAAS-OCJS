t = int(input().strip())
result = []
for i in range(t):
    letters = [0] * 26
    x = list(map(int, input().strip().split()))
    n, m = x[0], x[1]
    s = input().strip()
    positions = list(map(int, input().strip().split()))
    for k in s:
        letters[ord(k) - ord('a')] += 1
    helper = [0] * len(s)
    letters2 = [0] * len(s)
    for pos in positions:
        helper[pos - 1] += 1
    count = 0
    for index in range(len(s) - 1, -1, -1):
        count += helper[index]
        letters[ord(s[index]) - ord('a')] += count
    result.append(letters)
for i in result:
    res = ""
    for j in i:
        res += str(j) + " "
    print(res[:-1])