# B
def gcd(a, b):
    while b:
        a, b = b, a % b
    return a
T = int(input())
res_list = []

for _ in range(T):
    A, B, C, D = map(int, input().split())
    E = gcd(B, D)
    res = "Yes"
    if A < B:
        res = "No"
    if D < B:
        res = "No"
    if C < B - E:
        res = "No"
    F = A - ((A - C - 1) // B) * B - B
    if F < 0:
        res = "No"
    res_list.append(res)
for i in range(T):
    print(res_list[i])