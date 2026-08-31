def iinput():
    return [int(x) for x in input().split()]


def main():
    n = int(input())
    data = iinput()
    if n % 2 == 0:
        middle = n // 2
        if data[middle - 1] == middle - 1 and data[middle] == middle - 1:
            return 'No'
        for i in range(0, middle):
            if data[i] < i:
                return 'No'
        for i in range(middle, n):
            if data[i] < n - i - 1:
                return 'No'
    else:
        middle = n // 2 + 1
        for i in range(0, middle):
            if data[i] < i:
                return 'No'
        for i in range(middle, n):
            if data[i] < n - i - 1:
                return 'No'
    return 'Yes'


for t in range(int(input())):
    print(main())
