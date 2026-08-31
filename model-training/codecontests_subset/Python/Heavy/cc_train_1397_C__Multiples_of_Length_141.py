#python Problem C
import sys
def i():
    return sys.stdin.readline()[:-1]

n = int(i())
nums = list(map(int, i().split()))
if n == 1:
    print("1 1")
    print("0")
    print("1 1")
    print("0")
    print("1 1")
    print(-nums[0])
else:
    print(1,n-1)
    for x in range(len(nums)-1):
        print(((n-1)*(nums[x]%n)),end = ' ')
    print()
    print(n,n)
    print(-nums[n-1])
    print(1,n)
    for x in range(len(nums)-1):
        print(-(nums[x] + (n-1)*(nums[x]%n)), end = ' ')
    print("0")
