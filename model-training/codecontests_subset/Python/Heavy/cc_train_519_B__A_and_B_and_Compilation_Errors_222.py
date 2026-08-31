def solution():
    from sys import stdout, stdin
    _input, _print = stdin.readline, stdout.write
    _int, _range, _min, _max = int, range, min, max
    n = int(input())
    from collections import Counter
    arr_source = Counter(int(i) for i in input().split())
    arr_one = Counter(int(i) for i in input().split())
    arr_two = Counter(int(i) for i in input().split())
    l = set(arr_source.keys()).difference(set(arr_one.keys()))
    r = set(arr_one.keys()).difference(set(arr_two.keys()))
    if len(l) > 0:
        print(*l)
    else:
        for i in arr_source.keys():
            if arr_source[i] != arr_one[i]:
                print(i)
                break
    if len(r) > 0:
        print(*r)
    else:
        for i in arr_one.keys():
            if arr_one[i] != arr_two[i]:
                print(i)
                break
solution()
