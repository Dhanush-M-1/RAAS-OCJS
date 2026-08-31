def solution():
    from sys import stdout, stdin
    _input, _print = stdin.readline, stdout.write
    _range, _int, _enumerate, _str = range, int, enumerate, str
    for i in _range(_int(_input())):
        # string length, n length(p)
        m, n = [_int(i) for i in _input().split()]
        arr = '#'+_input().replace("\n","")
        from collections import defaultdict
        repeat = defaultdict(int)
        for i in _input().split():
            repeat[_int(i)] += 1
        ans = {v:i for i, v in _enumerate("abcdefghijklmnopqrstuvwxyz")}
        current = [0]*26
        summary = [0]*26
        for i, v in _enumerate(arr):
            if i == 0: continue
            current[ans[v]] += 1
            if i in repeat.keys():
                z = repeat[i]
                for j in _range(26):
                    summary[j] += current[j]*z
        for i in _range(26):
            summary[i] += current[i]
        _print("".join(_str(i)+' ' for i in summary)+"\n")
solution()
