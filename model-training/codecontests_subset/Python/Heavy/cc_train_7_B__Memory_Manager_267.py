from bisect import *

t, m = (int(x) for x in input().split())

class Block:
    def __init__(self, size, free, prv, nxt):
        self.size = size
        self.free = free
        self.prv = prv
        self.nxt = nxt

block0 = Block(0, m, None, None)
blocks = {}
next_id = 1

for i in range(t):
    c = input().split()
    
    if c[0] == "alloc":
        size = int(c[1])
        
        block = block0
        while block and block.free < size:
            block = block.nxt
        
        if not block:
            print("NULL")
            continue
        
        new = Block(size, block.free - size, block, block.nxt)
        
        block.free = 0
        
        new.prv.nxt = new
        if new.nxt:
            new.nxt.prv = new
        
        blocks[next_id] = new
        print(next_id)
        
        next_id += 1
    
    elif c[0] == "erase":
        id = int(c[1])
        
        if id not in blocks:
            print("ILLEGAL_ERASE_ARGUMENT")
            continue
        
        block = blocks[id]
        
        block.prv.free += block.size + block.free
        
        if block.prv:
            block.prv.nxt = block.nxt
        if block.nxt:
            block.nxt.prv = block.prv
        
        del blocks[id]
    
    elif c[0] == "defragment":
        defrag = 0
        
        block = block0
        while True:
            defrag += block.free
            block.free = 0
            if not block.nxt:
                break
            block = block.nxt
        
        block.free = defrag
