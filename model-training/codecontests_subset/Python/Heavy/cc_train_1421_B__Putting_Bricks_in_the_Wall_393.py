def main():
    t = int(input())
    for i in range(t):
        n = int(input())
        matrix = [input() for i in range(n)]
        c1, c2, c3, c4 = int(matrix[0][1]), int(matrix[1][0]), int(matrix[n-1][n-2]), \
                    int(matrix[n-2][n-1])
        answer = []
        if c1 == c2:
            if c3 == c1:
                answer.append((n, n-1))
            if c4 == c1:
                answer.append((n-1, n))

        elif c3 == c4:
            if c1 == c3:
                answer.append((1, 2))
            if c2 == c3:
                answer.append((2, 1))
        else:
            if c1 != 0:
                answer.append((1,2))
            if c2 != 0:
                answer.append((2, 1))
            if c3 != 1:
                answer.append((n, n-1))
            if c4 != 1:
                answer.append((n-1, n))
        print(len(answer))
        for j in answer:
            print(*j)


main()