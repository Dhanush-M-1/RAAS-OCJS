import os,io
input=io.BytesIO(os.read(0,os.fstat(0).st_size)).readline

class Solution:
    def __init__(self):
        #self.cache = {}
        self.mod = 10**9 + 7
        N = 2 * 10**5 + 1
        self.dp = [1] * N
        for i in range(10,N):
            self.dp[i] = (self.dp[i-10] + self.dp[i-9]) % self.mod
        
    
    def getLen(self, x):
        while x >= len(self.dp):
            self.dp.append((self.dp[-10] + self.dp[-9]))
        
        return self.dp[x]
        

    
    def solve(self, n, m):
        ans = 0
        while n > 0:
            dig = n % 10
            n //= 10
            ans = (ans + self.getLen(dig + m)) % self.mod
        
        return ans


        
s = Solution()
numCases = int(input())  
for i in range(1, numCases+1):
    n, m = map(int,input().split())
    ans = s.solve(n, m) 
    print("%d" % ans)