def main(input_f):
    t = int(input_f())
    for _ in range(t):
        n = int(input_f())
        cells = [list(input_f()) for _ in range(n)]
        start_right, start_bottom = cells[0][1], cells[1][0]
        finish_left, finish_top = cells[n - 1][n - 2], cells[n - 2][n - 1]
        inverted_cells = []
        if start_right == start_bottom:
            if finish_left == start_right:
                inverted_cells.append((n - 1, n - 2))
            if finish_top == start_right:
                inverted_cells.append((n - 2, n - 1))
        elif finish_left == finish_top:
            if start_right == finish_left:
                inverted_cells.append((0, 1))
            if start_bottom == finish_left:
                inverted_cells.append((1, 0))
        else:
            if start_right != '0':
                inverted_cells.append((0, 1))
            if start_bottom != '0':
                inverted_cells.append((1, 0))
            if finish_left != '1':
                inverted_cells.append((n - 1, n - 2))
            if finish_top != '1':
                inverted_cells.append((n - 2, n - 1))

        print(len(inverted_cells))
        for x, y in inverted_cells:
            print(x + 1, y + 1)


if __name__ == '__main__':
    main(input)
