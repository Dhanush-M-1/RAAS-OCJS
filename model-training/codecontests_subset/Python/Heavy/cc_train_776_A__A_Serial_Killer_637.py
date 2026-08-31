def serial_killer(first_pair, rest_pair):
    prev = first_pair.split()
    print("%s %s" % (prev[0], prev[1]))
    for each in rest_pair:
        curr = each.split()
        if curr[0] == prev[0]:
            prev = [prev[1], curr[1]]
        else:
            prev = [prev[0], curr[1]]
        print("%s %s" % (prev[0], curr[1]))


def main():
    names = input()
    name_pair = []
    for _ in range(int(input())):
        name_pair.append(input())
    serial_killer(names, name_pair)


if __name__ == '__main__':
    main()