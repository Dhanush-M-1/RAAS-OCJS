import sys
input = sys.stdin.readline
import fractions


def make_divisors(n):
    divisors = []
    for i in range(1, int(n**0.5)+1):
        if n % i == 0:
            divisors.append(i)
            if i != n // i:
                divisors.append(n//i)

    # divisors.sort()
    return divisors



def main():
    N = int(input())

    x = make_divisors(N)
    mi = [float("inf"), float("inf")]
    if len(x) == 1:
        print(1, 1)
        exit()
    if len(x) & 1:
        if (x[-1] * x[-1]) // fractions.gcd(x[-1], x[-1]) == N:
            mi = [x[-1], x[-1]]
    for i in range(0, len(x) - 1, 2):
        if (x[i] * x[i + 1]) // fractions.gcd(x[i], x[i + 1]) != N:
            continue
        if max(mi) > max(x[i], x[i + 1]):
            mi = [x[i], x[i + 1]]

    print(*mi)






if __name__ == '__main__':
    main()


