t = int(input())
for _ in range(t):
    n = int(input())
    nums = [list(map(int,input().split(" "))) for _ in range(n)]
    ans = "YES"
    p,c = nums[0]
    before_c = c
    before_p = p
    if c > p:
        ans = "NO"
    for num in nums[1:]:
        p, c = num
        challenges = p - before_p
        clear_diff = c - before_c
        if p < c or  p < before_p or  challenges < clear_diff or c < before_c  : #プレイ回数より多くのクリアはできない、プレイ回数は増える,挑戦できる回数よりクリア数は増えない
            ans = "NO"
        before_c = c
        before_p = p
    print(ans)