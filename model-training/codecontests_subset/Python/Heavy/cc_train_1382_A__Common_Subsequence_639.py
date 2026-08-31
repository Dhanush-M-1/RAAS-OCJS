
from collections import defaultdict

def solve(n, m, nums1, nums2):

    if nums1 is None or n == 0 or nums2 is None or m == 0:
        print("NO")
        return

    memo = defaultdict(lambda: 0)

    for num in nums1:
        memo[num] += 1

    for num in nums2:

        if num in memo:
            print("YES")
            print(1, num)
            return

    print("NO")
    return

if __name__ == "__main__":

    testCases = int(input())

    for case in range(testCases):
        n, m = map(int, input().split())
        nums1 = list(map(int, input().split()))
        nums2 = list(map(int, input().split()))

        solve(n, m, nums1, nums2)
