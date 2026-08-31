t = int(input())
for j in range(t):
    s, c = input().split()
    ar = [["a", -1]] * len(s)
    for i in range(len(s) - 2, -1, -1):
        if (ar[i + 1][0] <= s[i + 1]):
            ar[i] = ar[i + 1]
        else:
            ar[i] = [s[i + 1], i + 1]
    fl = True
    for i in range(len(s) - 1):
        if fl and s[i] > ar[i][0]:
            fl = False
            if s[:i] + ar[i][0] + s[i + 1:ar[i][1]] + s[i] + s[ar[i][1] + 1:] < c:
                print(s[:i] + ar[i][0] + s[i + 1:ar[i][1]] + s[i] + s[ar[i][1] + 1:])
            else:
                print("---")
    if fl:
        if (s < c):
            print(s)
        else:
            print("---")
