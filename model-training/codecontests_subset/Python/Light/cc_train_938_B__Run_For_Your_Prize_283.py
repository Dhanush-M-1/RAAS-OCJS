# cook your dish here
n=int(input())
a=list(map(int,input().split()))
max1=0
for  i in a:
    max1=max(max1,min(i-1,1000000-i))
print(max1)
        