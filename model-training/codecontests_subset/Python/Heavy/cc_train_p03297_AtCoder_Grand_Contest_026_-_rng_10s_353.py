# 【考察】
# 場合分けして考える。
# ★補充の機会無く尽きるケース
#   A < B or A % B > C だと補充されることなく在庫が尽きる。
# ★補充の機会が1回はあるケース（A >= B and A % B <= C ）
#   D < B だとどこかで在庫が尽きる。
#   D == B なら、補充＆購入でプラスマイナスゼロで釣り合う状態が続くので、買い続けられる。
#   D > Bのケースが問題。
#     補充されて補充ゾーンから抜け出しても、その後に補充の機会無く在庫が尽きることが起きうる。
#    「 初期のジュースの本数が X = A + N * D 本の時、補充の機会無く在庫が尽きるような正整数 N があるか？」
#     → 尽きるのは「X % B > C」のケース。
#        大前提として、B <= C + 1 だとこうなることはあり得ないので B > C + 1 で考える。
#        N を増やしていくと、 A % B、(A + D) % B、(A + 2 * D) % B、…と「D % B」ずつ増えていく。
#        こうして C + 1 ～ B - 1 の数が作れると、将来的に在庫が尽きることになる。
#        作れる数は(A + gcd(D, B)の倍数) % Bに限られる。
#        なので、B未満の最大の「A % B + gcd(D, B)の倍数」を求めて、それが　C + 1 ～ B - 1　内にあれば在庫が尽きる。
#        そうでなければ在庫は尽きない。
import math


def solve(A, B, C, D):
    if A < B or A % B > C:
        return 'No'
    if D < B:
        return 'No'
    if D == B:
        return 'Yes'
    # A >= B and A % B <= C and D > B
    if B <= C + 1:
        return 'Yes'
    g = math.gcd(B, D)
    n = (B - 1 - (A % B)) // g
    s = A % B + n * g
    if C + 1 <= s <= B - 1:
        return 'No'
    return 'Yes'


def main():
    T = int(input())
    ans = list()
    for _ in range(T):
        A, B, C, D = map(int, input().split())
        ans.append(solve(A, B, C, D))
    for a in ans:
        print(a)


if __name__ == '__main__':
    main()
