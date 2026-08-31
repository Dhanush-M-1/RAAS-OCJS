from sys import stdin, stdout
import traceback
from collections import Counter


read = stdin.readline
write = stdout.write
writeln = lambda x: write(str(x) + "\n")


def reads(typ=int):
    return list(map(typ, read().split()))


class Sol:
    def __init__(self, s, pp):
        self.s = s
        self.pp = pp
        self.n = len(self.s)

    @classmethod
    def input(cls):
        n, m = reads()
        s = read().strip()
        pp = reads()
        return cls(s, pp)

    def cum_count(self, counter):
        vsum = 0
        counts = sorted(counter.items())
        for (k, v) in reversed(counts):
            vsum += v
            counter[k] = vsum
        return counter

    def solve(self):
        self.pp.append(len(self.s))
        count_p = Counter(self.pp)
        count_p = self.cum_count(count_p)

        ret = [0] * 26
        last = 0
        for (p, times) in sorted(count_p.items()):
            for c in self.s[last:p]:
                ret[ord(c) - ord("a")] += times
            last = p
        return ret


if __name__ == "__main__":
    # print(Sol("ab" * 100000, [99999] * 100000).solve())

    try:
        for _ in range(int(read())):
            res = Sol.input().solve()
            writeln(" ".join([str(r) for r in res]))
    except Exception as e:
        print("Got exception:", repr(e))
        print(traceback.format_exc())
