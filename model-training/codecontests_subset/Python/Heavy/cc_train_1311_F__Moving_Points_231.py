''' Hey stalker :) '''
INF = 10 ** 10
def main():
    #print = out.append
    ''' Cook your dish here! '''
    n = get_int()
    points = get_list()
    speeds = get_list()
    point_indexes = dict()
    sorted_indexes = dict()

    for i, ele in enumerate(points):
        point_indexes[ele] = i

    for i, ele in enumerate(sorted(points)):
        sorted_indexes[ele] = i
    points.sort(reverse = True)
    points.sort(key=lambda x: speeds[point_indexes[x]], reverse = True)
    stree = SegTreeSum(n)
    scount = SegTreeSum(n)
    res = 0
    #print(points, point_indexes, sorted_indexes)
    for i in points:
        index = sorted_indexes[i]
        res += stree.query(index, n-1) - i*scount.query(index, n-1)
        stree.modify(index, i)
        scount.modify(index, 1)
        #print(res)
    print(res)


class SegTreeSum:
    def __init__(self, size):
        self.n = 1 << size.bit_length()
        self.li = [0]*(self.n<<1)

    def modify(self, index, ele):
        index += self.n
        self.li[index] = ele
        while index>1:
            self.li[index>>1] = self.li[index] + self.li[index^1]
            index >>= 1

    def get(self, index):
        return self.li[self.n + index]

    def query(self, l, r):
        #print('L - ', l, 'R - ',r)
        #[print(i, self.li[i]) for i in range(len(self.li))]
        res = 0
        l, r = l+self.n, r+self.n
        while l<=r:
            #print(l, r)
            if l&1==1: res += self.li[l]
            if r&1!=1: res += self.li[r]
            l = (l+1)>>1
            r = (r-1)>>1
        return res
''' Pythonista fLite 1.1 '''
import sys
from collections import defaultdict, Counter, deque
# from bisect import bisect_left, bisect_right
# from functools import reduce
# import math
input = iter(sys.stdin.buffer.read().decode().splitlines()).__next__
out = []
get_int = lambda: int(input())
get_list = lambda: list(map(int, input().split()))
main()
#[main() for _ in range(int(input()))]
print(*out, sep='\n')
