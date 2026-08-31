'''Author: Pranit Bhujel'''
import re

ls = lambda : list(map(int, input().split()))
ip = lambda : int(input())
sip = lambda : input()
r = lambda a : range(a)
lcm = lambda a, b: abs(a*b) // math.gcd(a, b)

'''showtime'''
if __name__=="__main__":
    t = ip()

    ''' looping through test cases '''
    for _ in r(t):
        n = ip()
        arr = ls()
        
        if (arr[0] + arr[1]) > arr[-1]:
            print(-1)
        else:
            print(1, 2, len(arr))