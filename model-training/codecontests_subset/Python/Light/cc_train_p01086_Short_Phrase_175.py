import sys


from inspect import currentframe


def pri(*args):
    names = {id(v): k for k, v in currentframe().f_back.f_locals.items()}
    # print(', '.join(names.get(id(arg), '???')+' = '+repr(arg) for arg in args))


def solve(n, w_count):
    pri("solve")
    right_count = [5, 7, 5, 7, 7]

    for i in range(n):
        locate = 0
        way_count = 0
        pri(i)

        for w_i in w_count[i:]:
            if right_count[locate] == w_i + way_count:
                locate += 1
                way_count = 0
            elif right_count[locate] > w_i + way_count:
                way_count += w_i
            else:
                break

            if locate == 5:
                print(i + 1)
                return


    return


if __name__ == '__main__':
    while True:
        n_input = int(input())
        if n_input == 0:
            break
        w_count_imput = [len(input()) for i in range(n_input)]

        solve(n_input, w_count_imput)


