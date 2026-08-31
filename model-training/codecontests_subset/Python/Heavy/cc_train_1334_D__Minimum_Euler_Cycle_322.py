n_tests = int(input())
for _ in range(n_tests):
    n_vertices, l, r = list(map(int, input().split()))
    index = 0
    i_v = None
    for i_v in range(1, n_vertices):
        n_indexes_here = (n_vertices - i_v) * 2
        if l <= index + n_indexes_here:
            break
        else:
            index += (n_vertices - i_v) * 2
    else:
        print(1)
        continue
    index += 1
    next_print = i_v + 1
    while True:
        if index > r:
            break
        if index % 2 == 1:
            if index >= l:
                print(str(i_v), end=" ")
        else:
            if index >= l:
                print(next_print, end=" ")
            next_print += 1
            if next_print > n_vertices:
                i_v += 1
                if i_v == n_vertices:
                    i_v = 1
                next_print = i_v + 1
        index += 1
    print("")
