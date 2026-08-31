def process(A, n):
    odd=[]
    even=[]
    for i in A:
        if i%2==1:
            odd.append(i)
        else:
            even.append(i)
    if abs(len(odd)-len(even))==1 or len(odd)==len(even) :
        return 0
    else:
        if len(odd) > len(even):
            a= len(odd)-1-len(even)
            odd.sort()
            return sum(odd[:a])
        elif len(odd) < len(even):
            b=len(even)-1-len(odd)
            even.sort()
            return sum(even[:b])

n=int(input())
A=[]
for x in input().split():
    A.append(int(x))
print(process(A, n))
