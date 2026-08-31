def main_function():
    a, b = [int(i) for i in input().split(" ")]
    counter = 0
    while True:
        if a < b:
            counter += a
            break
        a -= b
        a += 1
        counter += b
    return counter
print(main_function())




