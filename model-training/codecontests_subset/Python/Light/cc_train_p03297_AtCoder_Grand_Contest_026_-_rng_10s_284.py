from fractions import gcd
T = int(input())
for i in range(T):
    A, B, C, D = map(int, input().split())

    # 初日でケーキが買えない
    if B > A:
        print("No")
        continue

    # 毎日補充できても足りなくなる
    if B > D:
        print("No")
        continue

    # 買切る前に必ず入荷が発生する
    if C >= B:
        print("Yes")
        continue
        
    if B - gcd(B, D) + (A % gcd(B, D)) <= C:
        print("Yes")
    else:
        print("No")
