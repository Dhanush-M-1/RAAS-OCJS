n=input()
n=int(n)
sum=None
temp=0
for j in range(3):
    x=input()
    xno=x.split()
    for digit in xno:
        digit=int(digit)
        temp=temp+digit
    if sum is None:
        sum=temp
    else:
        print(sum-temp)
        sum=temp
    temp=0