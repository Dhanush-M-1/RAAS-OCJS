def get_the_missing_number(round_a, round_b):
    sum_a = sum(round_a)
    sum_b = sum(round_b)
    return sum_a - sum_b


if __name__ == "__main__":
    initial_number = int(input())
    row_a = list(map(int, input().split(" ")))
    row_b = list(map(int, input().split(" ")))
    row_c = list(map(int, input().split(" ")))
    print(get_the_missing_number(row_a, row_b))
    print(get_the_missing_number(row_b, row_c))
