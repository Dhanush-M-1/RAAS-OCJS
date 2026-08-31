expr = input().split()
target_number = int(expr[-1])
result_expr = None
def spread(number_sum, quantity):
    spreaded = []
    acc = number_sum
    remaining = quantity - 1
    for i in range(quantity):
        next_number = min(target_number, acc - remaining)
        spreaded.append(next_number)
        acc -= next_number
        remaining -= 1
    return spreaded
plus_count = 1 + expr.count('+')
minus_count = expr.count('-')
if minus_count == 0:
    if plus_count <= target_number <= plus_count*target_number:
        spreaded = spread(target_number, plus_count)
        result_expr = "{0} = {1}".format(" + ".join(map(str, spreaded)), target_number)
else:
    negatives = range(minus_count, minus_count*target_number + 1)
    for negative in negatives:
        positive = negative + target_number
        if plus_count <= positive <= plus_count*target_number:
            spreaded_positive = spread(positive, plus_count)
            spreaded_negative = spread(negative, minus_count)
            result_expr = "{0} ".format(spreaded_positive.pop())
            for i in range(1, len(expr) - 2):
                if expr[i] == '+':
                    result_expr += '+ {0} '.format(spreaded_positive.pop())
                elif expr[i] == '-':
                    result_expr += '- {0} '.format(spreaded_negative.pop())
            result_expr += "= {0}".format(target_number)
            break
        if positive > plus_count*target_number:
            break
if result_expr:
    print("Possible")
    print(result_expr)
else:
    print("Impossible")
