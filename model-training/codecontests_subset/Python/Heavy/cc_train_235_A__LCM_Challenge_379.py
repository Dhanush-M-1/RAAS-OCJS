'''''
arr= [1,3,4,3]
i=0
for k in range(8):
    if i!=arr[i]-1:
        if arr[i]!=arr[arr[i]-1]:
            print(arr[i],arr[arr[i]-1],arr,i)
            arr[i],arr[arr[i]-1]=arr[arr[i]-1],arr[i]
        else:
            i+=1
    else:
        i+=1
print(arr)
'''''

'''
def AllParenthesis(n):

    def backtrack(ans,curr,openp,closep,maxp):
        if len(curr)==2*maxp:
            ans.append(curr)
            return
        if openp<maxp:
            backtrack(ans,curr+"(",openp+1,closep,maxp)
        if closep<openp:
            backtrack(ans,curr+")",openp,closep+1,maxp)


    ans = []
    openp, closep = 0, 0
    curr = ''
    backtrack(ans, curr, openp, closep, n)
    return ans
print(AllParenthesis(3))
'''

#mat = [[1,2,3],[4,5,6],[7,8,9]]

'''temp=[[0 for x in range(len(mat[0]))]for x in range(len(mat))]
for i in range(len(mat)):
    temp[i][0]=mat[i][0]
    for j in range(1,len(mat[0])):
        temp[i][j]=temp[i][j-1]+mat[i][j]
for i in range(1,len(mat)):
    for j in range(len(mat[0])):
        temp[i][j]=temp[i-1][j]+temp[i][j]

k=3
lr=0
lc=0
rr=0
rc=0
ans=[[0 for x in range(len(mat[0]))]for x in range(len(mat))]
for i in range(len(mat)):
    for j in range(len(mat[0])):
        area1 = 0
        area2 = 0
        area3 = 0

        lr=i
        lc=j
        if i-k>=0:
            lr=i-k
        else:
            lr=0
        if j-k>=0:
            lc=j-k
        else:
            lc=0
        rr=i
        rc=j
        if i+k<len(mat):
            rr=i+k
        else:
            rr=len(mat)-1
        if j+k<len(mat[0]):
            rc=j+k
        else:
            rc=len(mat[0])-1
        if lc-1>=0:
            area1=temp[rr][lc-1]

        if lr-1>=0:
            area2=temp[lr-1][rc]
        if lr-1>=0 and lc-1>=0:
            area3=temp[lr-1][lc-1]
        ans[i][j]=temp[rr][rc]-area1-area2+area3'''


'''print(ans)'''
'''
nums = [-1,0,1,2,-1,-4]   #-1,0,1,2,-1,-4,-2,-3,3,0,4
nums.sort()
print(nums)
seen = set()
length=len(nums)
ans=[]
i=0
while i<length-2:
    l=i+1
    r=length-1
    target=nums[i]
    while l<r:
        if nums[l]+nums[r]==-target:
            seen.add((target,nums[l],nums[r]))

            while l < r and nums[l + 1] == nums[l]:
                l += 1
            while l < r and nums[r - 1] == nums[r]:
                r -= 1

            l+=1
            r-=1
        elif nums[l]+nums[r]>-target:
            r-=1
        else:
            l+=1
    i+=1
print(seen)
'''
import os
import sys
from io import BytesIO, IOBase


def main():
    pass


# region fastio

BUFSIZE = 8192


class FastIO(IOBase):
    newlines = 0

    def __init__(self, file):
        self._fd = file.fileno()
        self.buffer = BytesIO()
        self.writable = "x" in file.mode or "r" not in file.mode
        self.write = self.buffer.write if self.writable else None

    def read(self):
        while True:
            b = os.read(self._fd, max(os.fstat(self._fd).st_size, BUFSIZE))
            if not b:
                break
            ptr = self.buffer.tell()
            self.buffer.seek(0, 2), self.buffer.write(b), self.buffer.seek(ptr)
        self.newlines = 0
        return self.buffer.read()

    def readline(self):
        while self.newlines == 0:
            b = os.read(self._fd, max(os.fstat(self._fd).st_size, BUFSIZE))
            self.newlines = b.count(b"\n") + (not b)
            ptr = self.buffer.tell()
            self.buffer.seek(0, 2), self.buffer.write(b), self.buffer.seek(ptr)
        self.newlines -= 1
        return self.buffer.readline()

    def flush(self):
        if self.writable:
            os.write(self._fd, self.buffer.getvalue())
            self.buffer.truncate(0), self.buffer.seek(0)


class IOWrapper(IOBase):
    def __init__(self, file):
        self.buffer = FastIO(file)
        self.flush = self.buffer.flush
        self.writable = self.buffer.writable
        self.write = lambda s: self.buffer.write(s.encode("ascii"))
        self.read = lambda: self.buffer.read().decode("ascii")
        self.readline = lambda: self.buffer.readline().decode("ascii")


sys.stdin, sys.stdout = IOWrapper(sys.stdin), IOWrapper(sys.stdout)
input = lambda: sys.stdin.readline().rstrip("\r\n")

# endregion

if __name__ == "__main__":
    main()
import math
def check(n):
    '''   check = [1] * (n + 1)
    check[0] = 0
    check[1] = 0

    for i in range(2, int(math.sqrt(n)) + 1):
        if check[i] == 1:
            for j in range(i * i, n + 1, i):
                if check[j] == 1:
                    check[j] = 0

    def lcm(num1, num2):
        gcd1 = math.gcd(num1, num2)
        lcmf = (num1 * num2) // gcd1
        return lcmf'''

    if n==1:
        return 1
    if n==2:
        return 2
    if n==3:
        return 6
#    ans = 0
    if n&1:
        return ((n-1)*(n-2)*(n))
    if math.gcd(n,n-3)==1:
        return (n*(n-1)*(n-3))
    else:
        return ((n-1)*(n-2)*(n-3))
'''    k = j - 1
    for k in range(n-2, n-10, -1):
        lcm2 = lcm((n*(n-1)), k)
        if check[k]:
            return(lcm1*k)
'''
n =int(input())
print(check(n))
