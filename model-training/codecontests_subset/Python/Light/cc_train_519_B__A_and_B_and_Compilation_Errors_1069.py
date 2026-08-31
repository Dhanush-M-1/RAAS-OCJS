n=int(input())
s=list(map(int,input().split()))
p1=list(map(int,input().split()))
p2=list(map(int,input().split()))
s.sort();p1.sort();p2.sort()
p1.append(-10)
p2.append(-10)
p2.append(-10)
i=0;j=0;k=0
d1=0;d2=0
while i<=n-1:
    if s[i]==p1[j]:
        j+=1
    else:
        d1+=s[i]
    if s[i]==p2[k] :
        k+=1
    else:
        d2+=s[i]
    i+=1
print(d1)
print(d2-d1)