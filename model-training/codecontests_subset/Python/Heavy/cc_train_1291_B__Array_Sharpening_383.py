#from sys import maxsize
#from collections import Counter as cnt, defaultdict as dic
#import string
#from decimal import Decimal as de
get_int = lambda: int(input())
get_mul_int = lambda: map(int, input().rstrip().split())
get_list = lambda: list(map(int, input().rstrip().split()))

TEST_CASES = True
def main():
    n = get_int()
    a = get_list()
    i, j = 0, n-1
    while i<n:
        if a[i]<i:
            break
        i+=1
    while j>-1:
        if a[j]<n-j-1:
            break
        j-=1
    j+=1; i-=1
    print('YES') if i>=j else print('NO')
    
# START
if not TEST_CASES: main()
else: [main() for _ in range(int(input()))]





    
