# codeforces


def main():
    a = []
    for _ in range(int(input())):
        a.append(list(map(int, input().split())))
    for q in a:
        l = q[0]
        r = q[1]
        d = q[2]
        if d < l:
            print(d)
        else:
            print(d*(int(r/d)+1))

if __name__ == "__main__":
    main()

