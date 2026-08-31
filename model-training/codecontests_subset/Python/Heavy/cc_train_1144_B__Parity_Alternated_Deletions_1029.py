n=int(input())
ar=list(map(int,input().split()))
even=0
odd=0
for i in range(n):
    if ar[i]%2==0:
        even+=1
    else:
        odd+=1
l=abs(even-odd)
j=0
sum=0
if l<=1:
    print("0")
else:
    ar.sort()
    if(even>odd):
        for i in range(n):
            if ar[i]%2==0 and j<(l-1):
                j+=1
                sum+=ar[i]


        print(sum)

    if(even<odd):
        for i in range(n):
            if ar[i]%2!=0 and j<(l-1):
                j+=1
                sum+=ar[i]

        print(sum)
                
