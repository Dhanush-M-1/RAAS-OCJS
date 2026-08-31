#from sys import maxsize
#from collections import Counter as cnt, defaultdict as dic
#import string
get_int = lambda: int(input())
get_mul_int = lambda: map(int, input().rstrip().split())
get_list = lambda: list(map(int, input().rstrip().split()))

TEST_CASES = True
def main():
    n,m = get_mul_int()
    s=input()
    indices = get_list()
    a=[0]*26
    b=[0]*n
    for i in indices:
        b[i-1]+=1
    cdf_count=1
    for i in range(n-1,-1,-1):
        cdf_count+=b[i]
        a[ord(s[i])-97]+=cdf_count
    print(*a)
# START
if not TEST_CASES: main()
else: [main() for _ in range(int(input()))]




    
