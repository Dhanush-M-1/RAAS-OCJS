if __name__ == '__main__':
    for _ in range(int(input())):
        a, b, c = map(int, input().split())

        # PATH - 1

        x, y, z = a, b, c

        count1 = 0

        pos_y = y // 2

        count1 += min(x, pos_y) * 3

        y -= pos_y * 2

        count1 += min(y, z // 2) * 3

        # PATH - 2

        x, y, z = a, b, c

        count2 = 0

        pos_y = min(y, z // 2)

        y -= pos_y

        count2 += pos_y * 3

        count2 += min(x, y // 2) * 3

        print(max(count1, count2))
