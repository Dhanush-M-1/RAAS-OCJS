for _ in range(int(input())):
    n = int(input())
    prev_p = prev_c = 0
    ans = "YES"
    for _ in range(n):
        curr_p, curr_c = map(int, input().split())
        if curr_p < prev_p:
            ans = "NO"
        elif curr_p > prev_p:
            if curr_c < prev_c:
                ans = "NO"
            if curr_p - prev_p < curr_c - prev_c:
                ans = "NO"
        else:
            if prev_c != curr_c:
                ans = "NO"
        prev_p, prev_c = curr_p, curr_c

    print(ans)