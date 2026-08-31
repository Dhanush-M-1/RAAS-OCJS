def main():
    n = int(input())
    status = input()
    num_I = status.count('I')
    if num_I == 1:
        print(1)
    elif num_I > 1:
        print(0)
    else:
        print(status.count('A'))

if __name__ == "__main__":
    main()