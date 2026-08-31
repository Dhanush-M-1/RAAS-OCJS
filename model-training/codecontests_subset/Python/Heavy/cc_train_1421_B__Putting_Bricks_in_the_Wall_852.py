
import sys

def main(stream=sys.stdin):

    t = int(stream.readline())

    for _ in range(t):
        n = int(stream.readline())
        data = []
        for i in range(n):
            data.append([str(c) for c in stream.readline()])

        s = [data[0][1], data[1][0]]
        f = [data[n - 1][n - 2], data[n - 2][n - 1]]

        beg = s[0]
        end = str(1 - int(beg))

        if s[0] == s[1]:
            beg = s[0]
            end = str(1 - int(beg))
        elif f[0] == f[1]:
            end = f[0]
            beg = str(1 - int(end))


        points = []
        # check
        for i in range(2):
            for j in range(2):
                if i == j:
                    continue

                if data[i][j] != beg:
                    points.append((i + 1, j + 1))

                if data[n - i - 1][n - j - 1] != end:
                    points.append((n - i, n - j))

        print(len(points))
        for p in points:
            print("{} {}".format(*p))


if __name__ == '__main__':
    main()