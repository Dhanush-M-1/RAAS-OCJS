# https://codeforces.com/problemset/problem/1311/C
t = int(input().strip())

for _ in range(t):
    n,m = list(map(int,input().strip().split()))
    s = input().strip().lower()
    arr = list(map(int,input().strip().split()))
    arr.append(n)
    s_arr= [[0 for i in range(26)] for j in range(n)]
    for i in range(n):
        index = ord(s[i])-97
        if i==0:
            s_arr[i][index] = 1
            continue
        s_arr[i] = s_arr[i-1].copy()
        s_arr[i][index] +=1
    # print(s)
    # print(s_arr)
    ans = [0 for i in range(26)]
    for i in arr:
        for j in range(26):
            ans[j]+=s_arr[i-1][j]
    print(*ans)
    # break