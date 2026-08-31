N = int(input())
s = input()
ei = s.count("8")
m = N - ei
k = m // 10
if k <= ei:
    q = N - k * 11
    print(k + max(0, q // 11))
else:
    print(ei)