# cf 1060 A 800
n = int(input())
s = [*map(int, input())]
n8 = s.count(8)
while n8 > 0:
    if (len(s) - n8) // 10 >= n8:
        break
    n8 -= 1
print(n8)
