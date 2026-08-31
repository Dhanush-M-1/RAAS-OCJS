import sys
# sys.stdin = open("input.txt")
 

def main():
    tn = int(sys.stdin.readline())
    r = None
    for ti in range(tn):
        n = int(sys.stdin.readline())
        A = [int(a) for a in sys.stdin.readline().split()]
        if A[0] + A[1] <= A[-1]:
            print(f"1 2 {n}")
        else:
            print("-1")

 
if __name__ == "__main__":
    main()
