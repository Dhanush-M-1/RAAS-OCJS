from math import sqrt

cnt_t = int(input())


for t in range(cnt_t):
    n, m = [int(x) for x in input().split(" ")]

    s = input()
    fails = [int(x) for x in input().split(" ")]

    answer = [0] * 26
    for ch in s:
        answer[ord(ch)-97] += 1

    delta = len(fails)
    map_delta = [0] * n
    fails.sort(reverse=True)
    bound = fails.pop()

    for i in range(len(map_delta)):
        if i < bound - 1:
            map_delta[i] = delta
        elif i == bound - 1:
            map_delta[i] = delta
            delta -= 1
            prev_bound = bound
            if len(fails) == 0:
                continue
            bound = fails.pop()

            while len(fails) > 0 and prev_bound == bound:
                prev_bound = bound
                bound = fails.pop()
                delta -= 1
        else:
            map_delta[i] = 0
    for i, val in enumerate(map_delta):
        answer[ord(s[i])-97] += val

    for num in answer:
        print(num, end=" ")
    print("\n")
