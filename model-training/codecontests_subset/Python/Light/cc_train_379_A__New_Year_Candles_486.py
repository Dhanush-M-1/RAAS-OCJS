def main():
    a, b = [int(x) for x in input().split()]
    counter = a
    while a >= b:
        new_candles = a // b
        counter = counter + new_candles
        temp = a % b
        a = temp + new_candles
    print(counter)


main()
