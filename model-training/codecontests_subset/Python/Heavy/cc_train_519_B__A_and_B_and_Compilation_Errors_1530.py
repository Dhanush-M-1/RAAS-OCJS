def get_value():
    errors_count = int(input())
    initial_errors = sorted([int(val) for val in input().split()])
    second_errors = sorted([int(val) for val in input().split()])
    third_errors = sorted([int(val) for val in input().split()])
    a = None
    b = None

    for i in range(len(second_errors)):
        if second_errors[i] != initial_errors[i]:
            a = initial_errors[i]
            break

    if not a:
        a = initial_errors[-1]

    for i in range(len(third_errors)):
        if third_errors[i] != second_errors[i]:
            b = second_errors[i]
            break

    if not b:
        b = second_errors[-1]

    print(a, b)

if __name__ == "__main__":
    get_value()
