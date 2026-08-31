from math import gcd, sqrt
a, b = [int(i) for i in input().split()]


def primeFactors(n):
    fs = []
    while n % 2 == 0:
        fs.append(2)
        n = n / 2

    for i in range(3, int(sqrt(n)) + 1, 2):
        while n % i == 0:
            fs.append(int(i))
            n = n / i

    if n > 2:
        fs.append(int(n))
    return fs


def reduction_steps(num, greatest_commmon_denomenatior):
    possible_moves = [2, 3, 5]
    moves = 0
    pfacts = primeFactors(num)
    gcd_pfacts = primeFactors(greatest_commmon_denomenatior)
    for gcd_pfact in gcd_pfacts:
        pfacts.remove(gcd_pfact)
    for pfact in pfacts:
        if pfact in possible_moves:
            moves += 1
        else:
            return False, moves
    return True, moves


the_gcd = gcd(a, b)
a_steps = reduction_steps(a, the_gcd)
b_steps = reduction_steps(b, the_gcd)
if a_steps[0] and b_steps[0]:
    print(a_steps[1] + b_steps[1])
else:
    print(-1)