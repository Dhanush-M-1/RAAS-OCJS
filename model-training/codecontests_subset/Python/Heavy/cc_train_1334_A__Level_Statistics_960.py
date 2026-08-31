ANS = ""
def yesno(a):
    global ANS
    if a == 1:
        ANS += "YES"
    else:
        ANS += "NO"
    ANS += "\n"

for i in range(int(input())):
    n = int(input())
    ans = 1
    # n, m = [int(s) for s in input().split()]
    arr = []
    for i in range(n):
        arr.append([int(s) for s in input().split()])
    if (arr[0][0] < arr[0][1]):
        ans = 0
    for i in range(1, n):
        if (arr[i][0] < arr[i - 1][0]):
            ans = 0
        if (arr[i][1] < arr[i - 1][1]):
            ans = 0
        if (arr[i][0] - arr[i][1] < arr[i - 1][0] - arr[i - 1][1]):
            ans = 0
        if (arr[i][0] < arr[i][1]):
            ans = 0
    yesno(ans)
print(ANS)