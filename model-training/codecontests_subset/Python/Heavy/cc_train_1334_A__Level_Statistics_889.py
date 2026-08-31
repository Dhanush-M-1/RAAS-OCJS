import sys

def answer(n, p, c):
    num_p = p[0]
    num_c = c[0]
    if num_c > num_p:
        return 'NO'
    
    for i in range(1, n):
        num_p = p[i] - p[i-1]
        num_c = c[i] - c[i-1]
        if num_p < 0:
            return 'NO'
        if num_c < 0:
            return 'NO'
        if num_c > num_p:
            return 'NO' 
    return 'YES'
    
def main():
    T = int(input())
    while T:
        n = int(input())
        p = [0] * n
        c = [0] * n
        for i in range(n):
            p[i], c[i] = [int(i) for i in sys.stdin.readline().split()]
        print(answer(n, p, c))
        T -= 1
    return
main()