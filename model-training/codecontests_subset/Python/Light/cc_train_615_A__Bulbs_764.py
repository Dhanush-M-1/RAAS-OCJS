cases, b = map(int, input().split())
sta = set()
while cases:
    cases -= 1
    arr = list(map(int, input().split()))
    sta.update(set(arr[1:]))

if sum(sta) == b * (b + 1) // 2:
    print("YES")
else:
    print("NO")
