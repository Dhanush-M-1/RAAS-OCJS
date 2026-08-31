import math
t = int(input())
for _ in range(t):
    a, b, c, d = map(int, input().split())
    if a < b or b > d:  # 1手目から不可能、りんごが単調減少
        print("No")
        continue

    # ダメな場合とは　➡　bより小さいのに補充しない
    # (aから始まり、dを足していく) mod b > c
    # となる場合があったら無理
    g = math.gcd(b, d)
    max_rem = b - g + a % g
    if max_rem > c:
        print("No")
    else:
        print("Yes")
