def main():
    a, b = map(int, input().split())
    hours = a
    spare = a
    while spare >= b:
        new = spare // b
        hold = spare % b
        hours += new
        spare = hold + new
    print(hours)


main()