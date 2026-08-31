#import sys
#input = sys.stdin.readline
def solve():
    n = int( input())
    A = list( map( int, input().split()))
    if A[0] + A[1] <= A[-1]:
        return " ".join( map( str, [1,2,n]))
    else:
        return -1

def main():
    t = int( input())
    ANS = [ solve() for _ in range(t)]
    print("\n".join( map(str, ANS)))
if __name__ == '__main__':
    main()
