for _ in range(int(input())):
    n = int(input())
    ans = "yes";l1 = []
    for i in range(n):
        l1.append([int(x) for x in input().split()])
    for i in range(1, n):
        if l1[i][0] < l1[i - 1][0]: ans = "no";break
        elif l1[i][1] < l1[i - 1][1]: ans = "no";break
        elif l1[i][0] == l1[i - 1][0] and l1[i][1] != l1[i - 1][1]: ans = "no";break
        elif l1[i][1] > l1[i][0]: ans = "no"
        elif l1[i][1]-l1[i-1][1] > l1[i][0]-l1[i-1][0]: ans="no"
    if l1[0][1] > l1[0][0]: ans = "NO"
    print(ans)