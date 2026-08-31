# for testCase in range(int(input())):
n = int(input())
s = input()
ans = 0
for i in range(s.count('8')+1):
    ans = max(ans ,min(i ,(n-i)//10))
print(ans)
