from functools import reduce
import sys

class Read:
    @staticmethod
    def string():
        return input()
 
    @staticmethod
    def int():
        return int(input())
 
    @staticmethod
    def list(delimiter=' '):
        return input().split(delimiter)
 
    @staticmethod
    def list_int(delimiter=' '):
        return list(map(int, input().split(delimiter)))


# infilename = 'input.txt'
# sys.stdin = open(infilename, 'r')
# outfilename = 'output.txt'
# sys.stdout = open(outfilename, 'w')

def main():
    t = Read.int()
    for _ in range(t):
        n = Read.int()
        flag = True
        p = []
        c = []
        for i in range(n):
            tmp = Read.list_int()
            p.append(tmp[0])
            c.append(tmp[1])
        if (p[0] < c[0]):
            flag = False
        else:
            for i in range(1, len(p)):
                if (p[i] < c[i]) or (p[i] < p[i-1]) or (c[i] < c[i-1]) or ((c[i] > c[i-1]) and (p[i] == p[i-1]) or ((c[i]-c[i-1]) > (p[i]- p[i-1]))):
                    flag = False

        if flag:
            print("YES")
        else:
            print("NO")


if __name__ == '__main__':
    main()
