__file__ = __file__.startswith('/home/a_farazei')


def input_():
    global __file__

    if not __file__:
        return input()

    if not hasattr(__file__, 'readline'):
        __file__ = open('input.txt', 'r')

    return __file__.readline()


class Node:
    def __init__(self, val):
        self.val = val
        self.next = None
        self.prev = None


n, k = map(int, input_().split())
arr = sorted(map(int, input_().split()))
res = 0

nodes = [Node(x) for x in arr]

for i in range(n - 1):
    nodes[i].next = nodes[i + 1]

for i in range(1, n):
    nodes[i].prev = nodes[i - 1]

t = nodes[0]
q = t.next

while q and t:
    if t.val < q.val <= t.val + k:
        if t.prev:
            t = t.prev
            t.next = q
            q.prev = t
        else:
            t = q
            t.prev = None
            q = q.next
    else:
        t = q
        q = q.next

while t:
    res += 1
    t = t.prev


print(res)
