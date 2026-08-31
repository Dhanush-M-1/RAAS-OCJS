def solution():
    from sys import stdin, stdout
    _input, _print, _range, _int, _zip, _set, _len = stdin.readline, stdout.write, range, int, zip, set, len
    _min, _max, _str, _abs = min, max, str, abs
    n = _int(_input())
    for _ in _range(n):
        l = _int(_input())
        arr = [_int(i) for i in _input().split()]
        maximum = -1
        minimum = 1000000000
        m = 0
        old = arr[0]
        f = True if arr[0] == -1 else False
        for i in arr[1:]:
            if i >= 0:
                f = False
            if i == -1 and old == -1:
                old = i
                continue
            if i == -1 and old != -1:
                if old > maximum:
                    maximum = old
                if old < minimum:
                    minimum = old
                old = i
                continue
            if i != -1 and old == -1:
                if i > maximum:
                    maximum = i
                if i < minimum:
                    minimum = i
                old = i
                continue
            _m = _abs(old - i)
            if m < _m:
                m = _m
            old = i
        if minimum != 1000000000 and maximum != -1:
            average = (maximum + minimum) // 2
            _m = _max(maximum - average, average - minimum)
            if m < _m:
                m = _m
        # print("average",average, "m",m)
        if f:
            _print("0 42\n")
        else:
            _print(_str(m) + ' ')
            _print(_str(average) + '\n')


solution()