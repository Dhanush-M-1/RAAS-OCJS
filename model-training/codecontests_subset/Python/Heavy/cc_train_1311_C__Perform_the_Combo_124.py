letters = [
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "g",
    "h",
    "i",
    "j",
    "k",
    "l",
    "m",
    "n",
    "o",
    "p",
    "q",
    "r",
    "s",
    "t",
    "u",
    "v",
    "w",
    "x",
    "y",
    "z",
]
T = int(input())
for t in range(T):
    res = {l: 0 for l in letters}
    n, m = list(map(int, input().split()))
    s = input()
    p = list(map(int, input().split()))
    error_dict = {}
    # print(n, m, s, m)
    nb_times = len(p) + 1
    for pi in p:
        r = error_dict.get(pi, 0)
        error_dict[pi] = r + 1
    for i, letter in enumerate(s):
        # print(i, letter)
        nb_times -= error_dict.get(i, 0)
        # print(nb_times)
        res[letter] += nb_times
    r = [res[l] for l in letters]
    p = " ".join(map(str, r))
    print(p)
