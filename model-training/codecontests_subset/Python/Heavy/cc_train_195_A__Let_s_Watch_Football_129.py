def read_tokens():
    return input().strip().split(' ')


def read_ints():
    return [int(s) for s in read_tokens()]


# def how_many_problems(a: int, b: int, c: int):
#     l = 0
#     r = (c*a) // b
#
#     while r - l > 1:
#         m = (r + l) // 2
#         if possible(m, a, b, c):
#             l = m
#         else:
#             r = m
#
#     return l


# def possible(number_of_tasks: int, time_for_walk: int):
#     time_for_problems = sum([5*i for i in range(1, number_of_tasks+1)])
#     total_time = 4*60  # minutes
#     return (total_time - time_for_problems - time_for_walk) >= 0


def min_time_for_wait(a: int, b: int, c: int):
    l = 0
    r = (c*a) // b

    while r - l > 1:
        m = (r + l) // 2
        if possible(m, a, b, c):
            r = m
        else:
            l = m

    return r


def possible(t: int, a: int, b: int, c: int):
    total_video_data = c * a  # unit
    data_for_last_sec = (c + t) * b
    return data_for_last_sec >= total_video_data


a, b, c = read_ints()
print(min_time_for_wait(a, b, c))
