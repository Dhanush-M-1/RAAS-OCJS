import math
def facts(n):
    ans = []
    for  i in range(1, int(math.sqrt(n)+1)):
        if(n%i==0):
            ans.append(i)
            ans.append(n//i)
    ans = sorted(ans)
    return ans


for _ in range(int(input())):
    n = int(input())
    if(n==1):
        print(0)
    else:
        three, two = 0,0
        while(n%3==0):
            n//=3
            three+=1
        while(n%2==0):
            n//=2
            two+=1
        if(n==1 and two <= three):
            print(three-two+three)
        else:
            print(-1)
