from sys import stdin, stdout

class Input:
    def __init__(self):
        self.lines = stdin.read().splitlines()
        self.idx = 0
    
    def line(self):
        try:
            return self.lines[self.idx]
        finally:
            self.idx += 1
    
    def array(self, sep = ' ', cast = int):
        return list(map(cast, self.line().split(sep = sep)))
    
    def known_tests(self):
        num_of_cases, = self.array()
    
        for case in range(num_of_cases):
            yield self
    
    def unknown_tests(self):
        while self.idx < len(self.lines):
            yield self

def problem_solver():
    MOD = 998244353

    def mod(n, m = MOD):
        return (n % m)
    
    '''
    D. Rescue Nibel!
    '''
    def solver(inpt):
        n, k = inpt.array()
        a = [inpt.array() for i in range(n)]
        b = sorted([2 * x + 0 for x, y in a] + [2 * y + 1 for x, y in a])

        mp = [0, 1]
        for i in range(2, n + 1):
            mp.append(MOD - mod((MOD // i) * mp[MOD % i]))
        mem = []
        for i in range(n):
            if i < k - 1:
                mem.append(0)
            elif i == k - 1:
                mem.append(1)
            else:
                mem.append(mod(mod(mem[-1] * i) * mp[i - (k - 1)]))

        on = 0
        ans = 0
        for x in b:
            if x & 1:
                on -= 1
            else:
                ans = mod(ans + mem[on])
                on += 1

        print(ans)

    '''Returns solver'''
    return solver

try:
    solver = problem_solver()
    for tc in Input().unknown_tests():
        solver(tc)
except Exception as e:
    import traceback
    traceback.print_exc(file=stdout)