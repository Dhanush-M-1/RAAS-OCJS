''' Hey stalker :) '''
INF = 10**10
def main():
    #print = out.append
    ''' Cook your dish here! '''
    n = get_int()
    for x in range(int(n**0.5), 0, -1):
        if n%x==0 and math.gcd(x, n//x)==1:
            print(x, n//x)
            return


''' Pythonista fLite 1.1 '''
import sys
#from collections import defaultdict, Counter
#from functools import reduce
import math
#input = iter(sys.stdin.buffer.read().decode().splitlines()).__next__
out = []
get_int = lambda: int(input())
get_list = lambda: list(map(int, input().split()))
main()
#[main() for _ in range(int(input()))]
#print(*out, sep='\n')


