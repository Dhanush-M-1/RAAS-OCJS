#! /usr/bin/env python3

import sys
from math import factorial

class Node:

    def __init__(self, num):
        self.num = num
        self.binds = []
        # for dijkstra
        self.marker = False
        self.val = None

    def add_bind(self, oth):
        self.binds.append(oth)

    def __repr__(self):
        return '<{}: {}{}>'.format(
            self.num,
            [i.num for i in self.binds],
            ', \tval: {}'.format(self.val) if self.val != None else ''
            )

class Graph:

    def __init__(self, size):
        self.size = size
        self.nodes = [None] + [Node(num) for num in range(1, size+1)]

    def read_input(self):
        for _ in range(1, self.size):
            i, j = (int(x) for x in sys.stdin.readline().split())
            self.nodes[i].add_bind(self.nodes[j])
            self.nodes[j].add_bind(self.nodes[i])

    def __repr__(self):
        return '\n'.join(str(node) for node in self.nodes[1:])

def pairs(n):
    return factorial(n) // ( factorial(n-2) * 2 )

N = int(sys.stdin.readline())
g = Graph(N)
g.read_input()
#print(g)

ends = [node for node in g.nodes[1:] if len(node.binds) == 1]
#print('YES' if pairs(len(ends)) >= N-1 else 'NO')

for n in g.nodes[1:]:
    if len(n.binds) == 2:
        print('NO')
        break
else:
    print('YES')