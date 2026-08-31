from collections import defaultdict

def main():
    n = int(input())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))
    C = list(map(int, input().split()))

    print(sum(A)-sum(B))
    print(sum(B)-sum(C))

main()