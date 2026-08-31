"""
Accomplished using the EduTools plugin by JetBrains https://plugins.jetbrains.com/plugin/10081-edutools
"""


def solve():
    n = int(input())
    pow2 = 0
    while n % 2 == 0:
        pow2 += 1
        n //= 2
    pow3 = 0
    while n % 3 == 0:
        pow3 += 1
        n //= 3
    if n > 1:
        return -1
    if pow2 > pow3:
        return -1
    # pow2 <= pow3
    return 2 * pow3 - pow2


def main():
    t = int(input())
    for i in range(t):
        print(solve())


if __name__ == "__main__":
    # Write your solution here
    main()
