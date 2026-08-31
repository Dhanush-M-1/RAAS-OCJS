n,m=map(int,input().split())
left=n//m+n-(n//m)*m
count=n//m
while(True):
    count+=left//m
    left=left-(left//m)*m+left//m
    if left<m:
        break
output=n+count
print (output)