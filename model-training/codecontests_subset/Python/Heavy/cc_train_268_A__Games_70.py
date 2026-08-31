def main():
    try:
        # handle inputs
        n = input()
        if (not (2 <= int(n) <= 30)):
            exit(1)
        # validate inputs
        homeList = []
        guestList = []
        for i in range(int(n)):
            h, g = input().split()
            if (int(h) < 1 or int(g) > 100):
                exit(1)
            homeList.append(int(h))
            guestList.append(int(g))

        # format result
        counter = sum(guestList.count(h) for h in homeList)
        print(counter)

    except:
        exit(1)


if __name__ == "__main__":
    main()
