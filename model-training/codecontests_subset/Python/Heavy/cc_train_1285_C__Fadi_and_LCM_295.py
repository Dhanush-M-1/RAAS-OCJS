n = int(input())
prime_factors = {}
while n % 2 == 0:
    if 2 not in prime_factors:
        prime_factors[2] = 0
    prime_factors[2] += 1
    n /= 2
p = 3
while n > 1:
    while n % p == 0:
        if p not in prime_factors:
            prime_factors[p] = 0
        prime_factors[p] += 1
        n /= p
    if p*p > n:
        if int(n) not in prime_factors:
            prime_factors[int(n)] = 0
        prime_factors[int(n)] += 1
        break
    p += 2

# print(prime_factors)

a = 1
b = 1

nums = sorted([key**occ for key, occ in prime_factors.items() if key*occ != 1])
# print(nums)

def rec(a, b, nums):
    if len(nums) == 0:
        return (a,b)
    curr = nums[-1]
    nums.remove(curr)
    best_a = rec(a, b*curr, nums)
    best_b = rec(a*curr, b, nums)
    nums.append(curr)
    if max(best_a) < max(best_b):
        a = best_a[0]
        b = best_a[1]
    else:
        a = best_b[0]
        b = best_b[1]
    return (a,b)


a,b = rec(1, 1, nums)
print("{} {}".format(a,b))



# for key, occ in prime_factors.items():
#     if a > b:
#         b *= key * occ
#     else:
#         a *= key * occ

# print("{} {}\n".format(a, b))


