n = int(input())
nums = input()
cnt = nums.count('8')
n//=11
print(min(cnt, n))