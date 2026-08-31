errors_quantity = int(input())
# errors_quantity = 5
while errors_quantity < 3 or errors_quantity > 10 ** 5:
    errors_quantity = int(input())
list_of_errors = []
while len(list_of_errors) != errors_quantity:
    list_of_errors = list(map(int,input().split()))
    # list_of_errors = '1 5 8 123 7'.split()
    # for error in list_of_errors:
    #     while int(error) < 1 or int(error) > 10 ** 9 or error.isdigit() is False:
    #         list_of_errors = input().split()
    #         pass
    list_of_errors1 = list(map(int,input().split()))
    # list_of_errors1 = list(map(int,'123 7 5 1'.split()))
    print(sum(list_of_errors)-sum(list_of_errors1))
    list_of_errors2 = list(map(int,input().split()))
    # list_of_errors2 = '5 1 7'.split()
    print(sum(list_of_errors1)-sum(list_of_errors2))

