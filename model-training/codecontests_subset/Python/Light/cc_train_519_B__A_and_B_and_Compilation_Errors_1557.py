def sum(ar):
    sum=0
    for i in range(len(ar)):
        sum=sum+ar[i]
    return(sum)

t=int(input())
compilation=[]
for i in range(3):
    ele=list(map(int,input().split()))
    compilation.append(ele)
for i in range(0,2):
    print(sum(compilation[i])-sum(compilation[i+1]))