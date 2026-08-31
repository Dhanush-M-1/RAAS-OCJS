candles, reforge = map(int, input().split())


def candl(number, devider):
    result = number
    while number >= devider:
        left_behind = number % devider
        number = number // devider
        result += number
        number += left_behind
    return result


print(candl(candles, reforge))
