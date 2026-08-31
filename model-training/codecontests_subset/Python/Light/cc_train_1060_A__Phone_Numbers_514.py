def main():
    length = int(input())
    cards = input()
    n_eights = cards.count('8')
    max_numbers = length // 11

    print(min(n_eights, max_numbers))


if __name__ == '__main__':
    main()
