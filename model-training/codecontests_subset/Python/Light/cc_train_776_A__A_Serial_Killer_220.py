def main():
    n1, n2 = input().split()
    print(n1, n2)

    names = {n1, n2}
    k = int(input())
    for i in range(k):
        killed, new = input().split()
        names.remove(killed)
        names.add(new)
        for name in names:
            print(name, end=' ')
        print()


if __name__ == '__main__':
    main()
