def _379A(a, b):

    no_of_hours = a
    while(a // b > 0):

        no_of_hours += a // b
        a = a // b + a % b

    return(no_of_hours)

a, b = list(map(lambda x: int(x), input().split()))
print(_379A(a, b))
