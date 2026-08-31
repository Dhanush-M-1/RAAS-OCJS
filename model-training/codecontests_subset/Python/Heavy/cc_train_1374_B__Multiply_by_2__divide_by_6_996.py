def generatePrimeFactors(n):
    cnt2,cnt3=0,0
    while n%2==0:
        n=n//2
        cnt2+=1
    while n%3==0:
        n=n//3
        cnt3+=1
    #print(n)
    if n!=1:
        return -1
    else:
        return {2:cnt2,3:cnt3}
            
for _ in range(int(input())):
    n=int(input())
    dic=generatePrimeFactors(n)
    if dic==-1:
        print(-1)
        continue
    
    if dic[2]>dic[3]:
        print(-1)
        continue
    ans=dic[3]-dic[2]
    ans+=dic[3]
    print(ans)
    
    

