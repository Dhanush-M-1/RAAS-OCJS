def read_data():
    a = input()
    b = input()
    c = input()
    return a, b, c

def count_alphabets(S):
    counts = [0] * 26
    ord_a = ord('a')
    for s in S:
        counts[ord(s) - ord_a] += 1
    return counts

def solve(a, b, c):
    c_a = count_alphabets(a)
    c_a_copy = c_a[:]
    c_b = count_alphabets(b)
    c_c = count_alphabets(c)
    max_x = min(ca // cb for ca, cb in zip(c_a, c_b) if cb)
    record = 0
    best_pair = (0, 0)
    for x in range(max_x + 1):
        y = min(ca // cc for ca, cc in zip(c_a, c_c) if cc)
        if x + y > record:
            record = x + y
            best_pair = (x, y)
        c_a = [ca - cb for ca, cb in zip(c_a, c_b)]
    x, y = best_pair
    residue = [ca - x * cb - y * cc for ca, cb, cc in zip(c_a_copy, c_b, c_c)]
    residue = ''.join([chr(ord('a') + i) * r for i, r in enumerate(residue)])
    return b * x + c * y + residue

if __name__ == '__main__':
    a, b, c = read_data()
    print(solve(a, b, c))