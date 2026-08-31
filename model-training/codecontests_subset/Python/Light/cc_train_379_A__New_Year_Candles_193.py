a,b=map(int,input().split())
count=rem=0
while a!=0:
    count+=a
    rem+=a%b
    a=a//b
    
    if rem>=b:
        a+=rem//b
        rem=rem%b
print(count)