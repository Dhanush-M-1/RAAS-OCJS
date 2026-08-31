class TaskA(object):
    def __init__(self):
        self.get_data()
        self.solve()
        self.print_ans()
    pass

    def get_data(self):
        self.n = int(input())
        self.a = list()
        for _ in range(self.n):
            t = tuple(map(int, input().split()))
            self.a.append(t)
        pass

    def solve(self):
        self.ans = 0
        for i in range(self.n - 1):
            for j in range(i + 1, self.n):
                if self.a[i][0] == self.a[j][1]:
                    self.ans += 1
                if self.a[j][0] == self.a[i][1]:
                    self.ans += 1
        pass

    def print_ans(self):
        print(self.ans)
        pass


def main():
    TaskA()
    pass


if __name__ == '__main__':
    main()