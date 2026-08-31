from collections import Counter
t=int(input())
l=dict(Counter(list(map(int,input().split()))))
m=dict(Counter(list(map(int,input().split()))))
n=dict(Counter(list(map(int,input().split()))))

for i in l.keys():
    if(i not in m):
        l[i]-=1
        ans1=i
    elif(l[i]!=m[i]):
        l[i]-=1
        ans1=i
    
    if(l[i]!=0):
         
        if(i not in n):
            ans2=i
        elif(l[i]!=n[i]):
            ans2=i
print(ans1)
print(ans2)
    
