import sys
import math
input = lambda: sys.stdin.readline().rstrip()
# a,b,c = [int(v) for v in input().split()]


def solve(n) :
    temp = n
    
    num2 = 0
    num3 = 0
    
    while n%2 == 0 :
        num2 += 1
        n = n // 2
    
    while n%3 == 0 :
        num3 += 1
        n = n // 3
    
    if n != 1 or num2 > num3 :
        return -1
    else :
        return (num3-num2) + (num3)
    
def main() :
    t = int(input())
    for _ in range(t) :
        n = int(input())
        print(solve(n))
    
if __name__ == "__main__" :
    main()
