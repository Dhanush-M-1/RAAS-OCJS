def find_sides_indices(sorted_array):
    if sorted_array[0] + sorted_array[1] <= sorted_array[-1]:
        result = (0, 1, len(sorted_array) - 1)
    else:
        result = None
    return result


def main():
    t = int(input())
    for i in range(t):
        n = int(input())
        a = tuple(map(int, input().split()))
        indices = find_sides_indices(a)
        if indices is None:
            output = (-1,)
        else:
            output = sorted(i+1 for i in indices)
        print(*output)


if __name__ == '__main__':
    main()
