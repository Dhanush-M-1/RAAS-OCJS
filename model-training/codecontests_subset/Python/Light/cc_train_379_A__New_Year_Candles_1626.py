a,b= map(int,input().split())
count=a
burn=a
while(burn>=b):
    count+=burn//b
    rem=burn%b
    burn=burn//b+rem
print(count)



