def main():
    pwd = input()
    n = int(input())

    start = set()
    end = set()

    for i in range(n):
        word = input()
        if word == pwd:
            print("YES")
            exit(0)
        start.add(word[0])
        end.add(word[1])

    if pwd[0] in end and pwd[1] in start:
        print("YES")
    else:
        print("NO")


if __name__ == "__main__":
    main()
