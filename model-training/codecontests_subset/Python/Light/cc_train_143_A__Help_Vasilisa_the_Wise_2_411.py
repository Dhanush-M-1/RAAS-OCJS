def intger (l):
    ans=[]
    for i in l :
        ans.append(int(i))
    return ans
r=intger(input().split())
c=intger(input().split())
d=intger(input().split())
from itertools import permutations
myFlag=False
for i in permutations(range(1,10),4):
    if i[0]+i[1]==r[0] and i[2]+i[3]==r[1] and i[0]+i[2]==c[0] and i[1]+i[3]==c[1] and i[0]+i[3]==d[0] and i[1]+i[2]==d[1]:
        print(i[0],i[1])
        print(i[2],i[3])
        myFlag=True
if not myFlag:
    print(-1)