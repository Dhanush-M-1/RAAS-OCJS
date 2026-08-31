import sys
def ceil(a, b):
    return -(-a // b)

def answer(n, a):
    mnm = -1
    lindx = -1
    nums = set()
    for i in range(n):
        if a[i] > -1 and lindx > -1:
            if lindx != i-1:
                m = ceil( abs(a[i] - a[lindx]) , 2)
            else:
                m = abs(a[i] - a[lindx])
            mnm = max(mnm, m)
            lindx = i
        elif a[i] > -1:
            lindx = i
        else: #a[i] == 1
            if (i-1 >= 0):
                nums.add(a[i-1])
            if (i+1) <= n-1:
                nums.add(a[i+1])
    nums.discard(-1)
    if len(nums) == 0:
        print(0, 0)
        return
    #print('nums=', nums)
    mx = max(nums)
    mn = min(nums)
    best_k = (mx + mn) // 2
    mnm_nums = mx - best_k
    final_m = max(mnm_nums, mnm)
    print(final_m, best_k)
    return

def main():
    t = int(sys.stdin.readline())
    while t:
        n = int(sys.stdin.readline())
        a = list(map(int, sys.stdin.readline().split()))
        answer(n, a)
        t -= 1
    return
main()