import sys
import math


def ii(): return int(input())  # input int 1


def il(): return input().split(' ')  # input list


# input list of int: [1, 2, 3, ...]
def ili(): return [int(i) for i in input().split(' ')]


# input list of int splited: (a, b, c, ...)
def ilis(): return (int(i) for i in input().split(' '))


def ip(): return input()


def op(*args, **kwargs):
    print(*args, **kwargs)
    sys.stdout.flush()


def gcd(a, b): return a if b == 0 else gcd(b, a % b)


def extgcd(a, b, x=0, y=0):
    if b == 0:
        return (a, 1, 0)
    d, m, n = extgcd(b, a % b, x, y)
    return (d, n, m-(a//b)*n)


class UFS:
    def __init__(self, n):
        self.data = [i for i in range(n)]  # 记录每个节点的祖先节点
        self.size = [1] * n               # 记录每个节点的子树的节点数
        self.cnt = n                      # 记录当前的集合数量

    def find(self, m):
        if self.data[m] == m:
            return m
        ancestor = self.find(self.data[m])  # 找到祖先节点（根节点）
        self.data[m] = ancestor
        return ancestor

    def union(self, a, b):
        ancestor_a = self.find(a)
        ancestor_b = self.find(b)
        if ancestor_a == ancestor_b:
            return
        if self.size[ancestor_a] > self.size[ancestor_b]:
            self.data[ancestor_b] = ancestor_a
            self.size[ancestor_a] += ancestor_b
        else:
            self.data[ancestor_a] = ancestor_b
            self.size[ancestor_b] += ancestor_a
        self.cnt -= 1

    def query(self, a, b):
        return self.find(a) == self.find(b)


def main():
    n = ii()
    ufs = UFS(n+1)
    dels = []
    for i in range(n-1):  # 读入边
        u, v = ilis()
        if (ufs.query(u, v)):  # 无用边，加入可删除列表
            dels.append((u, v))
        else:  # 有用边，并查集中进行合并
            ufs.union(u, v)
    for i in range(n):  # 对每个节点进行路径压缩，确保父亲为集合祖先
        ufs.find(i+1)
    roots = list(set(ufs.data))  # 各集合的祖先
    roots.pop(0)  # 从1开始编号，故将0去除
    unum = len(roots) - 1  # 待补的边个数，即：集合数-1
    op(unum)  # 输出最少操作数，即待补边的个数
    for num in range(unum):  # 依次从可删除边列表取边，链接各集合祖先
        op(dels[num][0], dels[num][1], roots[0], roots[num+1])


if __name__ == "__main__":
    main()
