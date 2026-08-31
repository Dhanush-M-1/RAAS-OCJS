def main():
    m = [input() for _ in range(4)]
    m += list(zip(*m))
    m.append([m[i][i + 1] for i in range(3)])
    m.append([m[i][i] for i in range(4)])
    m.append([m[i + 1][i] for i in range(3)])
    m.append([m[i][2 - i] for i in range(3)])
    m.append([m[i][3 - i] for i in range(4)])
    m.append([m[i + 1][3 - i] for i in range(3)])
    for s in map(''.join, m):
        if any(p in s for p in (".xx", "x.x", "xx.")):
            print("YES")
            return
    print("NO")


if __name__ == '__main__':
    main()
