a, b = map(int, input().split())

cinder = 0  # кол-во потухших в остатке
accumulated = a  # накопленное
while a > 0:

    new = (cinder + a) // b
    cinder = (a + cinder - new * b)
    a = new
    accumulated += a
print(accumulated)
