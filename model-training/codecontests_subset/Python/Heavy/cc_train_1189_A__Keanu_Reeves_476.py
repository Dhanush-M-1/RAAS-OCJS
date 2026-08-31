n = input()  # length of string
s = input()  # the string

# initialize
rev_dict = {
    '0': '1',
    '1': '0',
}

def find_split(bin_str):
    '''find first occurence of digit other than starting digit'''
    start = bin_str[0]
    rem = bin_str[1:]
    pos = rem.find(rev_dict[start]) + 1
    return int(pos)
    

def split(bin_str, pos):
    '''split at arg pos'''
    ln = len(bin_str)
    s1 = bin_str[: pos]
    s2 = bin_str[pos: ]
    return s1, s2


def get_num_digs(bin_str):
    zeros = bin_str.count('0')
    ones = bin_str.count('1')
    return zeros, ones
    
def test_diff(bin_str):
    if bin_str.count('0') != bin_str.count('1'):
        return True
    else: return False
    
def test_done(parts, bin_str): 
    if ''.join(parts) == bin_str:
        return True
    
def pre_check(bin_str):
    '''Initial Dispositive Conditions
    '''
    # if we start with diff number of 1s and zeros    
    if bin_str.count('0') != bin_str.count('1'):
        print(f'1\n{bin_str}')
        return True
    else: return False
        
def finalize(parts):
    num = len(parts)
    print(num)
    print(*parts)
    
def main(bin_str):
    if pre_check(bin_str):
        return
    good_parts = []  # this will hold good substrings
    
    while True:
        # first split guarantees that s1 will be Good
        pos = find_split(bin_str)
        s1, s2 = split(bin_str, pos)
        
        # test print
        # print(f'from main: pos: {pos} s1, s2: {s1}, {s2}')
        # break
        
        good_parts.append(s1)
        bin_str = s2
        if test_diff(s2):
            good_parts.append(s2)
            finalize(good_parts)
            break
            
main(s)