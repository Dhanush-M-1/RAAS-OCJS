def get_value():
    errors_count = int(input())
    initial_errors = sorted([int(val) for val in input().split()])
    second_errors = sorted([int(val) for val in input().split()])
    third_errors = sorted([int(val) for val in input().split()])

    a = sum(initial_errors) - sum(second_errors)
    b = sum(second_errors) - sum(third_errors)

    print(a, b)

if __name__ == "__main__":
    get_value()
