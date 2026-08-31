def solve():
    n = int(input())
    array = list(map(int, input().split()))
    if n % 2 == 1:
        final = n // 2 + 1
    else:
        final = n // 2
        if array[final - 1] == array[final]:
            array[final] -= 1
    for i in range(final):
        if array[i] < i or array[n - 1 - i] < i:
            print("No")
            break
    else:
        if n % 2 == 1 or (n % 2 == 0 and array[final] != array[final - 1]):
            print("Yes")
        else:
            print("No")

T = int(input())
for i in range(T):
    solve()