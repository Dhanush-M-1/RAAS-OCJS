# The first line contains one integer t (1≤t≤100)  — the number of test cases.

T = int(input())

# Next t lines describe test cases in the following format:
#
# Line contains three non-negative integers a, b and c, separated by spaces (0≤a,b,c≤100) —
# the number of stones in the first, the second and the third heap, respectively.
for t in range(T):
    a, b, c = map(int, input().split())
    max2 = min(b, c // 2)
    max1 = min(a, (b - max2) // 2)
    # print(f'max2={max2} + max1={max1}')
    print((max2 + max1) * 3)

