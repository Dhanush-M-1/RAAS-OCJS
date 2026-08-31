#in the nmae of god
#Mr_Rubik
n,k=map(int,input().split())
sum=n
while (n>=k):
    sum+=n//k
    n=n//k+n%k
print(int(sum))