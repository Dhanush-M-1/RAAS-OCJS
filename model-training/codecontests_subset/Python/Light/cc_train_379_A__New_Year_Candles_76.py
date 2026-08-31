def get_hours():
    candles, partial_count = [int(x) for x in input().split()]

    return candles + get_sub_hours(candles, partial_count)


def get_sub_hours(candles, partial_count):
    additional_candles = int(candles / partial_count)
    additional_remainder = candles % partial_count
    additional_total = additional_candles + additional_remainder

    if additional_total >= partial_count:
        return additional_candles + get_sub_hours(additional_total, partial_count)

    return additional_candles

if __name__ == '__main__':
    print(get_hours())
