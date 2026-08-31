import sys

'''
3
11
4
100

011 xor 100
(0, 1), (1, 0), (1, 0)
'''

def xornachi(a,b,c):
    if c < 1:
        return a
    elif c == 1:
        return b

    bit_tuples = []
    while a > 0 or b > 0:
        bit_tuples.append((a&1, b&1))
        a >>= 1
        b >>= 1
    
    c_bits = []
    for a_bit,  b_bit in bit_tuples:
        c_bit = 0
        if (a_bit, b_bit) == (0, 0):
            pass
        elif (a_bit, b_bit) == (0, 1):
            # pattern is 1->0->1
            if c % 3 == 2:
                c_bit = 1
            elif c % 3 == 0:
                c_bit = 0
            else:
                c_bit = 1
        elif (a_bit, b_bit) == (1, 0):
            # pattern is 1->1->0
            if c % 3 == 2:
                c_bit = 1
            elif c % 3 == 0:
                c_bit = 1
            else:
                c_bit = 0
        elif (a_bit, b_bit) == (1, 1):
            # pattern is 0->1->1
            if c % 3 == 2:
                c_bit = 0
            elif c % 3 == 0:
                c_bit = 1
            else:
                c_bit = 1
        else:
            # this shouldn't happen
            assert False
        c_bits.append(c_bit)
        
    ans = 0
    for i, c_bit in enumerate(c_bits):
        ans += c_bit << i
    return ans

tests = sys.stdin.readlines()
for line in tests[1:]:
    a, b, c = [int(elem) for elem in line.split(' ')]
    print(xornachi(a, b, c))