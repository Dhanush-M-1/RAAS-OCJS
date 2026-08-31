import atexit
import io
import sys
_IB = sys.stdin.read().splitlines()
input = iter(_IB).__next__
_OB = io.StringIO()
sys.stdout = _OB
@atexit.register
def write():
    sys.__stdout__.write(_OB.getvalue())


# extra_ways_to_get_inputs


class inp:
    @staticmethod
    def int():
        return int(input())

    @staticmethod
    def ilist():
        return list(map(int, input().split()))

    @staticmethod
    def list():
        return input().split()

    @staticmethod
    def itup():
        return map(int, input().split())

    @staticmethod
    def str():
        return list(input())
# '''


def main():
    t = inp.int()
    for _ in range(t):
        n = inp.int()
        a = inp.ilist()
        up = True
        for i, ai in enumerate(a):
            if up:
                if ai >= i:
                    continue
                else:
                    break
        else:
            print("Yes")
            continue
        if i != 1:
            a = a[n-1:i-2:-1]
        else:
            a = a[n-1::-1]
        up = True
        for i, ai in enumerate(a):
            if up:
                if ai >= i:
                    continue
                else:
                    print("No")
                    break
        else:
            print("Yes")
            continue


if __name__ == '__main__':
    main()
