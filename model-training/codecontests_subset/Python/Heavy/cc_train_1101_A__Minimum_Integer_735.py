class Solution(object):
    def solve(self):
        n = int(input().strip())
        rtr = []
        for i in range(n):
            l, r, d = map(int, input().strip().split(' '))
            if d > r or d < l:
                rtr.append(d)
            elif d >= l:
                _add = int(r // d + 1)
                rtr.append(d * _add)
            else:
                _add = l % d
                if _add == 0:
                    _add = d
                if l - _add > 0:
                    rtr.append(l - _add)
                else:
                    _add = int(r // d + 1)
                    rtr.append(d * _add)
        return rtr


if __name__ == "__main__":
    sol = Solution()
    for x in sol.solve():
        print(x)
