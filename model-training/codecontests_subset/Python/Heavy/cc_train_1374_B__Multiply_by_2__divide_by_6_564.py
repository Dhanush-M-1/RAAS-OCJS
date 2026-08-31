"""
Given an integer n

In one move you can either:
    multiply by 2
    or divide by 6 (if div by 6)

Given a number n determine the minimum number of moves required to get it to 1
If it is impossible print -1

This is only possible if n has factors 2 and 3
This is also only possible if there are more factors of 3 than 2
And the answer is given by the deficit of 2s to 3s + log(result)
"""


def check(n):
    if n == 1:
        return 0

    # Count how many factors of 2 and 3 it has
    two_count, three_count = 0, 0

    while n % 2 == 0:
        n /= 2
        two_count += 1

    while n % 3 == 0:
        n /= 3
        three_count += 1

    if two_count > three_count:
        return -1

    if n != 1:  # If its factors are only 2 and 3 then it should only be 1
        return -1

    times_2 = three_count - two_count
    div_6 = three_count

    return times_2 + div_6


t = int(input())

for i in range(t):
    n = int(input())
    print(check(n))


