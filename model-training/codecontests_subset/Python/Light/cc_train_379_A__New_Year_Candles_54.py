if __name__ == "__main__":
    ab = input().split()
    a = int(ab[0])
    b = int(ab[1])

    result = a
    debris = a

    while debris >= b:
        result += int(debris / b)
        debris = int(debris / b) + debris % b

    print(result)