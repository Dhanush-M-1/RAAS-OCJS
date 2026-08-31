#519B

def solve(first_errors, second_errors, third_errors):

    first_sum = sum(first_errors)
    second_sum = sum(second_errors)
    third_sum = sum(third_errors)

    print (first_sum - second_sum)
    print (second_sum - third_sum)


if __name__ == "__main__":

    input()
    first_errors = map(int,input().split(" "))
    second_errors = map(int,input().split(" "))
    third_errors = map(int,input().split(" "))

    solve(first_errors, second_errors, third_errors)
