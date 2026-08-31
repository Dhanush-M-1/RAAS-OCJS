# python 3
"""
"""
from operator import itemgetter


def help_vasilisa_the_wise_2(r_1_int, r_2_int, c_1_int, c_2_int, d_1_int, d_2_int) -> None:
    solution = True

    quotient, remainder = divmod(r_1 + c_1 - d_2, 2)
    if remainder == 0:
        x_1 = quotient
    else:
        solution = False
    quotient, remainder = divmod(r_1 + c_2 - d_1, 2)
    if remainder == 0:
        x_2 = quotient
    else:
        solution = False
    quotient, remainder = divmod(r_2 + c_1 - d_1, 2)
    if remainder == 0:
        x_3 = quotient
    else:
        solution = False
    quotient, remainder = divmod(r_2 + c_2 - d_2, 2)
    if remainder == 0:
        x_4 = quotient
    else:
        solution = False
    if solution and x_1 != x_2 and x_1 != x_3 and x_1 != x_4 and x_2 != x_3 and x_2 != x_4 and x_3 != x_4 \
            and 1 <= x_1 <=9 and 1 <= x_2 <= 9 and 1 <= x_3 <= 9 and 1 <= x_4 <= 9:
        solution = True
    else:
        solution = False
    if solution:
        print(x_1, x_2)
        print(x_3, x_4)
    else:
        print(-1)


if __name__ == "__main__":
    """
    Inside of this is the test. 
    Outside is the API
    """

    r_1, r_2 = list(map(int, input().split()))
    c_1, c_2 = list(map(int, input().split()))
    d_1, d_2 = list(map(int, input().split()))

    help_vasilisa_the_wise_2(r_1, r_2, c_1, c_2, d_1, d_2)
