x=int(input())
import math
import fractions

#最小公倍数
def union_lcm(lists):
    if len(lists)==1:
        return lists[0]
    elif len(lists)>1:
        num=lists[0]
        for i in range(1,len(lists)):
            num=num*lists[i]//fractions.gcd(num,lists[i])
        return num
    
mini=10**12
minipare=(1,10**12)
sqrt=int(math.sqrt(x))+1
for i in range(1,sqrt+1):
    if x%i==0:
        a=i
        b=x//i
        if union_lcm([a,b])==x and max(a,b)<mini:
            minipare=(a,b)
        
        
    else:
        pass
print(*minipare)
    