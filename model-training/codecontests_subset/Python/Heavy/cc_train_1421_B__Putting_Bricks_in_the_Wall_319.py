import sys as _sys


ZERO = '0'
ONE = '1'


def main():
    t = int(input())
    for i_t in range(t):
        n, = _read_ints()
        a = tuple(tuple(_read_line()) for i_row in range(n))
        result = tuple(find_cells_to_invert(a))
        print(len(result))
        for x, y in result:
            if x < 0:
                x += n
            if y < 0:
                y += n
            x += 1
            y += 1
            print(y, x)


def _read_line():
    result = _sys.stdin.readline()
    assert result[-1] == "\n"
    return result[:-1]


def _read_ints():
    return map(int, _read_line().split())


def find_cells_to_invert(matrix):
    assert len(matrix) == len(matrix[0])
    n = len(matrix)
    assert n >= 3
    
    get_by_pos = lambda pos: matrix[pos[1]][pos[0]]
    
    cell_a, cell_b = (0, 1), (1, 0)
    cell_c, cell_d = (-1, -2), (-2, -1)
    value_a, value_b = get_by_pos(cell_a), get_by_pos(cell_b)
    value_c, value_d = get_by_pos(cell_c), get_by_pos(cell_d)
    
    if value_a != value_b and value_c != value_d:
        if get_by_pos(cell_a) == ONE:
            yield cell_a
        else:
            yield cell_b
        if get_by_pos(cell_c) == ZERO:
            yield cell_c
        else:
            yield cell_d
    
    elif value_a == value_b:
        value_to_avoid = value_a
        if value_c == value_to_avoid:
            yield cell_c
        if value_d == value_to_avoid:
            yield cell_d
    
    else:
        assert value_c == value_d
        value_to_avoid = value_c
        if value_a == value_to_avoid:
            yield cell_a
        if value_b == value_to_avoid:
            yield cell_b


if __name__ == '__main__':
    main()
