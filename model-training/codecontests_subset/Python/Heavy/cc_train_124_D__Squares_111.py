
a, b, x_1, y_1, x_2, y_2 = map(int, input().split())

a_b, a_e = (x_2 + y_2), (x_1 + y_1)
b_b, b_e = (x_2 - y_2), (x_1 - y_1)

if a_b > a_e:
    a_b, a_e = a_e, a_b

if b_b > b_e:
    b_b, b_e = b_e, b_b


if a_b % (2 * a) != 0:
    a_b = (a_b // (2 * a) + 1) * (2 * a)

a_result, b_result = 0, 0

if a_b <= a_e:
    a_result = (abs(a_e - a_b) + (2 * a - 1)) // (2 * a)

if b_b % (2 * b) != 0:
    b_b = (b_b // (2 * b) + 1) * (2 * b)

if b_b <= b_e:
    b_result = (abs(b_e - b_b) + (2 * b - 1)) // (2 * b)

print(max([a_result, b_result]))


