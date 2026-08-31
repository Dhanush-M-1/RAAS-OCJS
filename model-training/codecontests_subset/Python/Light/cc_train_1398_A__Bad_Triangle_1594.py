# imports
# helpers
# solution

def solution(n, nums):
    first = nums[0]
    last = nums[n-1]
    for i in range(1, n-1):
        if first+nums[i] <= last:
            return f"1 {i+1} {n}"
    return -1


# setup
if __name__ == '__main__':
    tests = int(input().strip())
    for _ in range(tests):
        n = int(input().strip())
        nums = list(map(int, input().strip().split()))
        print(solution(n, nums))