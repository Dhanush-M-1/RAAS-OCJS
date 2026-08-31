def count8(x):
    return str(x).count("8")


n = int(input())

s = input()

c8 = count8(s)

bolum = n // 11

if c8 >= bolum:
    print(bolum)

else:
    print(c8)
