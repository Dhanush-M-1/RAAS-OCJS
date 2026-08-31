import sys
import math
from collections import defaultdict,deque

input = sys.stdin.readline
def inar():
    return [int(el) for el in input().split()]
def main():
    n=int(input())
    winner=0
    sp=3
    loser=0
    ans="YES"
    for i in range(n):
        take=int(input())
        if take==sp:
            ans="NO"
            break
        else:
            winner=take
            if winner==1 and sp==2:
                sp=3
            elif winner==1 and sp==3:
                sp=2
            elif winner==2 and sp==3:
                sp=1
            elif winner==2 and sp==1:
                sp=3
            elif winner==3 and sp==1:
                sp=2
            else:
                sp=1
    print(ans)




if __name__ == '__main__':
    main()



