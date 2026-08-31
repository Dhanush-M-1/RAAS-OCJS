#CF-650 (DIV-3)

'''test=int(input())
for i in range(test):
    b=input()
    ans=""
    if len(b)==2:
        ans=b
    else:
        ans+=b[0]
        j=1
        while j<len(b)-1:
            ans+=b[j]
            j+=2
        ans+=b[-1]
    print(ans)
'''
'''test=int(input())
for i in range(test):
    n=int(input())
    arr=[int(i) for i in input().split()]
    type1=0
    type2=0
    for i in range(n):
        if i%2==0 and arr[i]%2==1:
            type1+=1
        elif i%2==1 and arr[i]%2==0:
            type2+=1
    if type1!=type2:
        print(-1)
    else:
        print(type1)'''


'''test=int(input())
for i in range(test):
    n,k=[int(i) for i in input().split()]
    binary=input()
    suff=[float("inf")]*(n)
    suff[-1]=0 if binary[-1]=="1" else float("inf")
    for j in range(len(binary)-2,-1,-1):
        if binary[j]=="1":
            suff[j]=0
        else:
            suff[j]=1+suff[j+1]
    last=-1
    ans=0
    for i in range(len(binary)):
        if binary[i]=="0":
            if last!=-1:
                if i-last>k and suff[i]>k:
                    ans+=1
                    last=i
            elif suff[i]>k:
                ans+=1
                last=i
        else:
            last=i
    print(ans)'''


'''test=int(input())
for i in range(test):
    import heapq
    s=input()
    m=int(input())
    arr=[int(i) for i in input().split()]
    s=sorted("".join([i for i in s]))
    heap=[]
    for i in range(m):
        heapq.heappush(heap,(arr[i],i))
    ans=[""]*(m)
    t=0
    while heap:
        a,b=heapq.heappop(heap)
        while True:
            sum_=0
            for i in range(m):
                if ans[i]!="":
                    sum_+=abs(b-i)
            if sum_==a:
                break
            else:
                t+=1
        ans[b]=s[t]
    print("".join(ans))'''

#CODEFORCES GLOBAL ROUND

'''test=int(input())
for i in range(test):
    a,b,n=[int(i) for i in input().split()]
    ans=0
    while a<=n and b<=n:
        if a>=b:
            b+=a
        else:
            a+=b
        ans+=1
    print(ans)'''

'''k=int(input())
item="codeforces"
print(item,end="")
printable=10**(3)
s="s"*(10**(3))
k-=1
while k>printable:
    print(s,end="")
    k-=printable
print("s"*(k))'''

# codeforces 651 DIV-2

'''test=int(input())
for i in range(test):
    n=int(input())
    l=1
    r=n
    ans=1
    while l<=r:
        mid=l+(r-l)//2
        if mid*2<=n:
            ans=mid
            l=mid+1
        else:
            r=mid-1
    print(ans) '''


'''test=int(input())
for i in range(test):
    n=int(input())
    if n==1:
        print("FastestFinger")
    elif n%2:
        print("Ashishgup")
    elif n==2:
        print("Ashishgup")
    elif n&(n-1)==0:
        print("FastestFinger")
    else:
        res=[]
        i=2
        while i**2<=n:
            cnt=0
            while n%i==0:
                n=n//i
                cnt+=1
            res.append((i,cnt))
            i+=1
            #print(i,n)
        if n>1:
            res.append((n,1))
        prime=0
        alpha=0
        for i in res:
            if i[0]!=2:
                prime+=i[1] 
            else:
                alpha=i[1]
        if alpha>1:
            print("Ashishgup")
        elif prime>=2:
            print("Ashishgup")
        else:
            print("FastestFinger")'''

'''n,k=[int(i) for i in input().split()]
arr=[int(i) for i in input().split()]
'''

'''test=int(input())
for i in range(test):
    n=int(input())
    arr=[int(i) for i in input().split()]
    eve=[]
    odd=[]
    if n==2:
        print(3,4,sep=" ")
    else:
        for i in range(len(arr)):
            if arr[i]%2:
                odd.append(i)
            else:
                eve.append(i)
        if len(odd)%2:
            odd.pop()
            eve.pop()
        else:
            if len(eve)>=2:
                eve.pop()
                eve.pop()
            else:
                odd.pop()
                odd.pop()
        j=0
        while j<len(odd):
            print(odd[j]+1,odd[j+1]+1)
            j+=2
        k=0
        while k<len(eve):
            print(eve[k]+1,eve[k+1]+1)
            k+=2'''
    


'''n,k=[int(i) for i in input().split()]
arr=[int(i) for i in input().split()]

def check(x,p):
    ans=0
    for i in range(len(arr)):
        if (not p):
            ans+=1
            p^=1
        else:
            if arr[i]<=x:
                ans+=1
                p^=1
    return ans>=k

l=1
r=10**9
res=0

while l<=r:
    mid=l+(r-l)//2
    if check(mid,0) or check(mid,1):
        res=mid
        r=mid-1
    else:
        l=mid+1
print(res)
'''
                
#ATCODER BEGINNER
# CODEFORCESDIV-2 ROUND 652

'''test=int(input())
for i in range(test):
    n=int(input())
    if n==3:
        print("NO")
    elif (n-2)%2:
        print("NO")
    else:
        if ((n-2)//2)%2:
            print("YES")
        else:
            print("NO")'''

'''test=int(input())
for i in range(test):
    n=int(input())
    s=input()
    last=len(s)
    res=s[0]
    for i in range(len(s)-1,-1,-1):
        if s[i]=="0":
            last=i
            break
    if last==len(s):
        print(s)
    else:
        j=-1
        k=0
        while k<=last and s[k]!="1":
            j+=1
            k+=1
        if j==last:
            print(s)
        else:
            print(s[:j+1]+s[last:])

    else:
        for i in range(1,last):
            if s[i]=="0" and res[-1]!="1":
                res+=s[i]
            elif s[i]=="1":
                res+=s[i]
        i=len(res)-1
        while i>=0 and res[i]!="0":
            i-=1
        print(res[:i+1]+s[last:])'''
    
    
    





'''test=int(input())
from collections import defaultdict
for i in range(test):
    n,k=[int(i) for i in input().split()]
    arr=[int(i) for i in input().split()]
    w=[int(i) for i in input().split()]
    ans=[[]]*(k)
    if n==k:
        print(2*sum(arr))
    else:
        cnt=defaultdict(int)
        for i in arr:
            cnt[i]+=1
        #print(cnt)
        res=sorted(cnt.items(),key=lambda x:x[0],reverse=True)
        w.sort()
        for i in range(len(res)):
            for j in range(res[i][1]):
                for k in range(len(w)):
                    if w[k]>0:
                        ans[k].append(res[i][0])
                        w[k]-=1
        t=0
        for p in ans:
            t+=max(p)+min(p)
        print(t) '''


'''n=int(input())
arr=[int(i) for i in input().split()]
dp=[1]*(max(arr)+1)
ele=set()
for i in arr:
    ele.add(i)
for i in range(2,max(arr)+1):
    if i in ele and dp[i]:
        j=2
        while i*j<=max(arr):
            if i*j in ele:
                dp[i*j]=0
            j+=1
cnt=0
for i in range(2,len(dp)):
    if i in ele and dp[i]:
        cnt+=1
if len(ele)==1:
    print(0)
else:
    print(cnt)'''


#Practice DIV2-c

'''n,s=[int(i) for i in input().split()]
def pos(n,s):
    if s>=0 and s<=9*n:
        return True
    return False
if n==1:
    if s>9:
        print(-1,-1)
    else:
        print(s,s)
elif s==0:
    if n==1:
        print(0,0)
    else:
        print(-1,-1)

else:
    temp=s
    minn=""
    for i in range(n):
        for j in range(10):
            if (i>0 or j>0 or (n==1 and j==0)) and pos(n-i-1,s-j):
                minn+=str(j)
                s-=j
                break
        
    maxx=""
    for i in range(n):
        for j in range(9,-1,-1):
            if (i>0 or j>0 or (n==1 and j==0)) and pos(n-i-1,temp-j):
                maxx+=str(j)
                temp-=j
                break
    if minn and maxx:
        print(minn,maxx)
    else:
        print(-1,-1)'''

'''n,m=[int(i) for i in input().split()]
price=[int(i) for i in input().split()]
from collections import defaultdict
graph=defaultdict(set)
for i in range(m):
    p,c=[int(i) for i in input().split()]
    graph[p].add(c)
    graph[c].add(p)
minn=[]
print(graph)
def check(i,j,k):
    if j in graph[i] and k in graph[i] and k in graph[j]:
        return True
    return False
for i in range(1,n-1):
    for j in range(i+1,n-1):
        for k in range(j+1,n-1):
            if check(i,j,k):
                minn.append(price[i]+price[j]+price[k])
print(minn)

if minn:
    print(min(minn))
else:
    print(-1)'''

#CODEFORCES ROUND EDUCATIONAL 90
'''
test=int(input())
for i in range(test):
    a,b,c=[int(i) for i in input().split()]
    if a>c:
        print(-1,1)
    elif a==c:
        print(-1,b)
    else:
        p=b if c/b<a else -1
        print(1,p)
'''
'''test=int(input())
for i in range(test):
    s=input()
    ones=0
    zero=0
    for i in s:
        if i=="1":
            ones+=1
        else:
            zero+=1
    if zero==0 or ones==0:
        print("NET")
    else:
        if len(s)%2==0:
            if ones%2:
                print("DA")
            else:
                print("NET")
        else:
            t=min(zero,ones)
            if t%2:
                print("DA")
            else:
                print("NET")'''

'''test=int(input())
for i in range(test):
    s=input()
    dp=[0]*(len(s))
    balance=-1 if s[0]=="-" else 1
    max_=0
    dp[0]=1 if s[0]=="-" else 0
    for i in range(1,len(s)):
        balance+=1 if s[i]=="+" else -1
        if balance<0:
            if dp[i-1]+balance<0:
                dp[i]=-balance
            else:
                dp[i]=dp[i-1]
        else:
            dp[i]=dp[i-1]
    ans=0
    #print(dp)
    from collections import defaultdict
    cnt=defaultdict(lambda:-1)
    for i in range(len(dp)):
        cnt[dp[i]]=i
    ans=0
    #print(cnt)
    for i in range(max(dp)+1):
        ans+=min(cnt[i]+2,len(s))
    print(ans)'''

'''test=int(input())
for i in range(test):
    n=int(input())
    arr=[int(i) for i in input().split()]
    reverse=[]
    for i in range(len(arr)):
        if i%2==0:
            if i+1<len(arr) and arr[i]>arr[i+1]:
                reverse.append((arr[i+1]-arr[i])
    ans=0
    for i in range(len(arr)):
        if i%2==0:
            ans+=arr[i]
    print(ans)'''
    

'''n=int(input())
factors=[]
i=2
def checker(power):
    l=1
    r=20
    ans=1
    while l<=r:
        mid=l+(r-l)//2
        if mid*(mid+1)/2<=power:
            ans=mid
            l=mid+1
        else:
            r=mid-1
    return ans
while i**2<=n:
    if n%i==0:
        cnt=0
        while n%i==0:
            n/=i
            cnt+=1
        factors.append([i,cnt])
    i+=1
if n>1:
    factors.append([n,1])

res=0
rem=0
for i in range(len(factors)):
    a=checker(factors[i][1])
    res+=a
    factors[i][1]-=a
    rem+=factors[i][1]

#print(factors)
print(int(res))
'''

# CF 653 DIV_3

'''test=int(input())
for i in range(test):
    x,y,n=[int(i) for i in input().split()]
    k=n//x
    if n%x==y:
        print(n)
    elif x*k+y>n:
        print(x*k-(x-y))
    else:
        print(x*k+y)'''

test=int(input())
for i in range(test):
    n=int(input())
    two=0
    three=0
    if n==1:
        print(0)
    else:
        while n%2==0:
            n=n//2
            two+=1
        while n%3==0:
            n=n//3
            three+=1
        if n>1:
            print(-1)
        elif two>three:
            print(-1)
        elif two<three:
            print(2*three-two)
        else:
            print(three)



    




