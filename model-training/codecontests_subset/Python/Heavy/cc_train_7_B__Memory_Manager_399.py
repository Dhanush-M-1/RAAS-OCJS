'''
Jana Goodman6

7B Memory Manager

'''
import re

SPACE = ' '
ALLOC = 'alloc'
ERASE = 'erase'
DEFRAG = 'defragment'
ALLOC_ERR = 'NULL'
ERASE_ERR = 'ILLEGAL_ERASE_ARGUMENT'
FREE = 0

class Memory:
    def __init__(self, size):
        self.size = size
        self.next_id = 0
        self.bytes = [FREE] * size

    def is_free(self, block):
        return all(byte == FREE for byte in block)

    def is_allocated(self, id):
        return id in self.bytes

    def free_block(self, n):
        block_len, start = None, None
        for i, byte in enumerate(self.bytes):
            if byte == FREE:
                if block_len is None:
                    start = i
                    block_len = 1
                else:
                    block_len += 1
                if block_len == n:
                    return start
            else:
                block_len = None
        return None

    def fill(self, start, n, x):
        if start == 78 and start + n == 90:
            debug = 1
        for i in range(start, start + n):
            self.bytes[i] = x

    def alloc(self, n):
        start = self.free_block(n)
        if start is None:
            print(ALLOC_ERR)
        else:
            self.next_id += 1
            self.fill(start, n, self.next_id)
            print(self.next_id)

    def erase(self, x):
        if x == 0:
            print(ERASE_ERR)
        elif self.is_allocated(x):
            self.fill(self.bytes.index(x),
                      self.bytes.count(x), FREE)
        else:
            print(ERASE_ERR)

    def defragment(self):
        new_bytes = list()
        if FREE in self.bytes:
            n = 0
            for byte in self.bytes:
                if byte > FREE:
                    new_bytes.append(byte)
                    n += 1
            new_bytes += [FREE] * (self.size - len(new_bytes))
            self.bytes = [_ for _ in new_bytes]

# noinspection PyTypeChecker
def process_mem(mem, ops):
    for op in ops:
        # if op == 'alloc 12':
        #     debug = 2
        if ALLOC in op:
            mem.alloc(int(re.findall('\d+', op)[0]))
        elif ERASE in op:
            mem.erase(int(re.findall('\d+', op)[0]))
        else:
            mem.defragment()

if __name__ == '__main__':
    t, m = map(int, input().strip().split(SPACE))
    ops = [input().strip() for _ in range(0, t)]
    # if t == 93 and m == 83:
    #     s = ''
    #     for op in ops:
    #         if 'defragment' in op:
    #             s += 'd|'
    #         elif 'alloc' in op:
    #             s += 'a' + op.split(SPACE)[1] + '|'
    #         else:
    #             s += 'e' + op.split(SPACE)[1] + '|'
    #         if len(s) > 100:
    #             print(s)
    #             s = ''
    #     print(s)
    process_mem(Memory(m), ops)

