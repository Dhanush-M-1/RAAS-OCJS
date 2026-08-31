from sys import stdin, stdout

def rsingle_int():
    return int(stdin.readline().rstrip())

def rmult_int():
    return [ int(x) for x in stdin.readline().rstrip().split() ]

def r_str():
    return stdin.readline().rstrip()
    
def rsingle_char():
    return stdin.read(1)

def main():
    N = rsingle_int()
    chars = []
    n_ones = 0
    n_zeros = 0
    s = r_str()
    for i in range(N):
        c = s[i]
        if c == '1':
            n_ones += 1
        else:
            n_zeros += 1
    if n_ones != n_zeros:
        print(1)
        print(s)
    else:
        print(2)
        print(s[:N-1] + " " + s[N-1])

 
main()