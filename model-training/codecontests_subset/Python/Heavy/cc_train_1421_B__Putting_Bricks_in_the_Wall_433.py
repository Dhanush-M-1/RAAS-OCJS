from collections import Counter, deque

# Make GRID a global variable to avoid copying data during function calls
GRID = []
SMALL_DIAGONAL = [(0, 1), (1, 0)]
BIG_DIAGONAL = [(0, 2), (1, 1), (2, 0)]

def get_input():
    return input().split()

def get_int_input():
    return map(int, get_input())

def _is_valid_cell(cell, n):
    if cell[0] >= n or cell[1] >= n:
        return False
    return True

def is_there_a_path(n):
    '''
        Do a bfs traversal to find for any valid path
    '''
    queue = deque([((0, 0), '0'), ((0, 0), '1')])
    FINAL_CELLS = [(n - 1, n - 2), (n - 2, n - 1)]

    while queue:
        cell, digit = queue.popleft()
        if cell in FINAL_CELLS:
            return True

        # Move right
        new_cell = (cell[0] + 1, cell[1])
        if _is_valid_cell(new_cell, n):
            if GRID[new_cell[0]][new_cell[1]] == digit:
                queue.append((new_cell, digit))

        # Move down
        new_cell = (cell[0], cell[1] + 1)
        if _is_valid_cell(new_cell, n):
            if GRID[new_cell[0]][new_cell[1]] == digit:
                queue.append((new_cell, digit))

    return False

def C1421B(n):
    ans_count = 0
    ans_cells = [] # list of string
    if (
        len(Counter([GRID[cell[0]][cell[1]] for cell in BIG_DIAGONAL])) == 1 and
        len(Counter([GRID[cell[0]][cell[1]] for cell in SMALL_DIAGONAL])) == 1 and
        GRID[BIG_DIAGONAL[0][0]][BIG_DIAGONAL[0][1]] != GRID[SMALL_DIAGONAL[0][0]][SMALL_DIAGONAL[0][1]]
    ):
        return 0
    elif len(Counter([GRID[cell[0]][cell[1]] for cell in BIG_DIAGONAL])) == 1:
        big_diagonal_value = GRID[BIG_DIAGONAL[0][0]][BIG_DIAGONAL[0][1]]
        for cell in SMALL_DIAGONAL:
            if GRID[cell[0]][cell[1]] == big_diagonal_value:
                ans_count += 1
                ans_cells.append(' '.join(map(str, [val + 1 for val in cell])))
    elif GRID[0][1] == GRID[1][0]:
        small_diagonal_value = GRID[SMALL_DIAGONAL[0][0]][SMALL_DIAGONAL[0][1]]
        for cell in BIG_DIAGONAL:
            if GRID[cell[0]][cell[1]] == small_diagonal_value:
                ans_count += 1
                ans_cells.append(' '.join(map(str, [val + 1 for val in cell])))
    else:
        counter = Counter([GRID[cell[0]][cell[1]] for cell in BIG_DIAGONAL])
        inv_counter = {counter[c]: c for c in counter}
        more_occurring_value = inv_counter.get(3, '') or inv_counter.get(2, '')
        for cell in SMALL_DIAGONAL:
            if GRID[cell[0]][cell[1]] == more_occurring_value:
                ans_count += 1
                ans_cells.append(' '.join(map(str, [val + 1 for val in cell])))
        for cell in BIG_DIAGONAL:
            if GRID[cell[0]][cell[1]] != more_occurring_value:
                ans_count += 1
                ans_cells.append(' '.join(map(str, [val + 1 for val in cell])))
    return str(ans_count) + '\n' + '\n'.join(ans_cells)

def main():
    t, = get_int_input()

    for _ in range(t):
        globals()['GRID'] = []
        n, = get_int_input()

        for _ in range(n):
            GRID.append(list(input()))

        # n is equal to len(GRID)
        print(C1421B(n))

main()
