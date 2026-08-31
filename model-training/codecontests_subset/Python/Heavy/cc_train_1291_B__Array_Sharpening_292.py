def solve(n, a):
    i = 0
    j = len(a) - 1
    while i <= n - 1:
        if a[i] >= i:
            i += 1
        else: 
            i -= 1
            break

    while j >= 0:
        if a[j] >= len(a) - 1 - j:
            j -= 1
        else: 
            j += 1
            break

    if i == n - 1 or j == 0 or i - j >= 0: 
        return "Yes"
    return "No"


def main():
    for _ in range(int(input())):
        n = int(input())
        a = list(map(int, input().split()))
        print(solve(n, a))


main()
