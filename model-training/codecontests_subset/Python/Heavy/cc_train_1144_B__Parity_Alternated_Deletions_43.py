N = int(input())
M = sorted(map(int, input().split()))
flag = 1
odd, even = [], []


def odd_even(n):
    if n % 2 == 0:
        return 'Even'
    else:
        return 'Odd'


for n in M:
    if odd_even(n) == 'Even':
        even.append(n)
    else:
        odd.append(n)


def max_del(M):
    M.pop(-1)
    return M


if len(even) > len(odd):
    flag = 1
elif len(even) < len(odd):
    flag = -1
else:
    if min(even) > min(odd):
        flag = 1
    else:
        flag = -1

while flag != 2:
    if flag == 1:
        even.pop(-1)
        flag *= -1
        if len(odd) == 0: flag = 2
    else:
        odd.pop(-1)
        flag *= -1
        if len(even) == 0: flag = 2
print(sum(odd) + sum(even))