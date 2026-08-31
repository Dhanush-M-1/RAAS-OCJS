import collections, heapq

def solution():
    n = int(input().strip())
    a = [int(x) for x in input().strip().split(" ")]

    known = float("-inf")
    m, M = float("inf"), float("-inf")
    for i in range(len(a)-1):
        if a[i] == -1:
            if a[i+1] != -1:
                m = min(m, a[i+1])
                M = max(M, a[i+1])
        else:
            if a[i+1] == -1:
                m = min(m, a[i])
                M = max(M, a[i])
            else:
                known = max(known, abs(a[i]-a[i+1]))
    
    if m == float("inf"):
        if known == float("-inf"):
            diff = 0
            k = 0
        else:
            diff = known
            k = 0
    else:
        k = (m+M)//2
        diff = max(known, abs(k-m), abs(k-M))
    print(diff, k)

        


def main():    
    T = int(input().strip())
    for _ in range(T):
        solution()
    

main()