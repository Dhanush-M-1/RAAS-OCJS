from heapq import heapify, heappop, heappush
import sys
input = sys.stdin.buffer.readline

def main():
    n,k = map(int,input().split())
    A = []; B = []; AorB = []; C = []
    for __ in range(n):
        t,a,b = map(int,input().split())
        if a == b == 1:
            C.append(t)
        elif a == 1:
            A.append(t)
            AorB.append(t)
        elif b == 1:
            B.append(t)
            AorB.append(t)
    if len(A) + len(C) < k or len(B) + len(C) < k:
        print(-1); exit()
    A.sort(); B.sort(); C.sort()
    C = C[:min(k,len(C))]

    ans = 0
    nokori = k - len(C)
    for i in range(nokori):
        ans += A[i] + B[i]
    
    ab_idx = nokori
    while C and ab_idx < len(A) and ab_idx < len(B) and C[-1] >= A[ab_idx] + B[ab_idx]:
        C.pop()
        ans += A[ab_idx] + B[ab_idx]
        ab_idx += 1
    ans += sum(C)
    print(ans)

if __name__ == '__main__':
    main()