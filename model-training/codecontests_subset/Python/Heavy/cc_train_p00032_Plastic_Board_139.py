# coding=utf-8


def is_rect(quadr):
    if quadr[0]**2 + quadr[1]**2 == quadr[2]**2:
        return True
    return False


def is_rhombus(quadr):
    if quadr[0] == quadr[1]:
        return True
    return False


if __name__ == '__main__':
    counter_list = [0, 0]
    while True:
        try:
            quadr = list(map(int, input().split(',')))
            if is_rect(quadr):
                counter_list[0] += 1
            if is_rhombus(quadr):
                counter_list[1] += 1
        except EOFError:
            break
    print(counter_list[0])
    print(counter_list[1])

