a, b = input().strip().split(' ')
n = int(input().strip())
print("{} {}".format(a, b))
for _ in range(n):
    na, nb = input().strip().split(' ')
    if a == na:
        a = nb
    elif b == na:
        b = nb
    print('{} {}'.format(a, b))
