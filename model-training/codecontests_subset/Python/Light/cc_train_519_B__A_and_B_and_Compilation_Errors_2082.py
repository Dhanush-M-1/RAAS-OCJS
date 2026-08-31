n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
c = list(map(int, input().split()))
sa = sb = sc = 0
for i in range(n-2):
    sa += a[i]
    sb += b[i]
    sc += c[i]
sb += b[-1]
sa += a[-1] + a[-2]
print(sa - sb)
print(sb - sc)