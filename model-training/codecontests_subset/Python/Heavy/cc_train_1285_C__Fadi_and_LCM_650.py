import math


class Read:
    @staticmethod
    def string():
        return input()

    @staticmethod
    def int():
        return int(input())

    @staticmethod
    def list(sep=' '):
        return input().split(sep)

    @staticmethod
    def list_int(sep=' '):
        return list(map(int, input().split(sep)))

def lcm(a, b):
    return int(a * b / math.gcd(a, b))

def solve():
    x = Read.int()
    if x < 6:
        print('1 ' + str(x))
    else:
        i = math.floor(math.sqrt(x))
        if i * i == x:
            i -= 1
        while True:
            t = x // i
            if x % i == 0 and lcm(i, t) == x:
                print('{} {}'.format(i, x//i))
                return
            i -= 1


query_count = 1
# query_count = Read.int()
while query_count:
    query_count -= 1
    solve()
