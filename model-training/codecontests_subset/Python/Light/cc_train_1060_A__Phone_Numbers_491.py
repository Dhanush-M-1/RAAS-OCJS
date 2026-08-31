n=int(input())
# ns=[int(x)for x in input().split()]
s=input()
nums=[0]*2
for c in s:
    if ord(c)-ord('0')==8:
        nums[0]+=1
    else:
        nums[1]+=1

def fetch10():
    if sum(nums)<10:
        return False
    if nums[1]>=10:
        nums[1]-=10
    else:
        nums[0]-=(10-nums[1])
        nums[1]=0
def fetch11():
    if nums[0]<=0:
        return False
    nums[0]-=1
    if fetch10()==False:
        return False
    return True

ans=0
while fetch11():
    ans+=1

print(ans)