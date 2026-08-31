a, b = map(int, input().split())
cur_b = 0
counter = 0
while a > 0:
    counter += a
    cur_b += a
    a, cur_b  = cur_b // b, cur_b % b
print(counter)   