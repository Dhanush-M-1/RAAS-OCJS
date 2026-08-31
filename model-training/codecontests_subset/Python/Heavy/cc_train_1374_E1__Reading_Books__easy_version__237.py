import sys

def answer(n, k, t, a, b):
    t_both = []
    t_a = []
    t_b = []
    for i in range(n):
        if a[i] == 1 and b[i] == 1:
            t_both.append(t[i])
        elif a[i] == 1:
            t_a.append(t[i])
        elif b[i] == 1:
            t_b.append(t[i])
    if k > ( len(t_both) + min(len(t_a), len(t_b)) ) :
        return -1
    
    t_both.sort()
    t_a.sort()
    t_b.sort()
    both_ctr = 0
    ab_ctr = 0
    ans = 0
    for i in range(k):
        best_t_both = 10**5
        best_ind = 10**5
        if both_ctr < len(t_both):
            best_t_both = t_both[both_ctr]
        if ab_ctr < min(len(t_a), len(t_b)):
            best_ind = t_a[ab_ctr] + t_b[ab_ctr]
        
        if best_t_both < best_ind:
            ans += best_t_both
            both_ctr += 1
        else:
            ans += best_ind
            ab_ctr += 1

    return ans

def main():
    n, k = map(int, sys.stdin.readline().split())
    t = [0 for _ in range(n)]
    a = [0 for _ in range(n)]
    b = [0 for _ in range(n)]
    for i in range(n):
        t[i], a[i], b[i] = map(int, sys.stdin.readline().split())
    print(answer(n, k, t, a, b))
    return
main()