

def main():

    n = int(input())
    arr = list(map(int, input().split()))

    even, odd = [], []
    for i in range(n):
        if arr[i] % 2 == 0:
            even.append(arr[i])
        else:
            odd.append(arr[i])

    turn = 1 if len(even) > len(odd) else -1
    can = True
    even.sort(reverse=True)
    odd.sort(reverse=True)
    while can:
        if turn == 1 and len(even) > 0:
            even.pop(0)
        elif turn == -1 and len(odd) > 0:
            odd.pop(0)
        else:
            can = False
        turn *= -1

    print(sum(even) + sum(odd))


if __name__ == "__main__":
    main()