from sys import stdin, stdout


def write(_s):
    stdout.write(_s)


def write_int(_s):
    stdout.write(str(_s))


def write_list(_l):
    stdout.write(" ".join(map(str, _l)))


def read():
    return stdin.readline().split(" ")


def readint():
    return int(stdin.readline())


def read_int_l():
    return map(int, stdin.readline().split(" "))


n, k = read_int_l()
a = sorted(read_int_l())

pref_sum = [0] * (n + 1)
for i in range(n):
    pref_sum[i + 1] += pref_sum[i] + a[i]

min_moves = float("inf")
n_to_left = 0
while n_to_left < n:
    n_to_right = n_to_left
    while n_to_right < n and a[n_to_right] == a[n_to_left]:
        n_to_right += 1

    curr_element = a[n_to_left]
    same_element_count = n_to_right - n_to_left
    # cost to get all left elements to curr_element - 1
    cost_left = n_to_left * (curr_element - 1) - pref_sum[n_to_left]
    # cost to get all right elements to curr_element + 1
    cost_right = pref_sum[n] - pref_sum[n_to_right] - \
        (curr_element + 1) * (n - n_to_right)

    # the current element suffices
    if same_element_count >= k:
        min_moves = 0

    # moving the left elements
    if same_element_count + n_to_left >= k:
        min_moves = min(min_moves, cost_left + (k - same_element_count))

    # moving the right elements
    if same_element_count + (n - n_to_right) >= k:
        min_moves = min(min_moves, cost_right + (k - same_element_count))

    min_moves = min(min_moves, cost_left + cost_right +
                    (k - same_element_count))

    n_to_left = n_to_right

write_int(max(min_moves, 0))
