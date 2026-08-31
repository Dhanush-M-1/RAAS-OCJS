
num  = int(input())
even, odd= 0, 0
a=list(map(int,input().split()))

for i in range(0,num):
    if a[i]&1 == 0:
        even +=1
    else: odd+=1
a.sort()
Sum = 0
Del = min(even, odd )*2 + 1
Del = min(num,Del)
Del = num -Del

if Del>0:
    if even>odd:
        for i in range(0,num):
            if a[i]&1 ==0:
                Sum += a[i]
                Del -= 1

            if Del ==0 : break
    else:
        for i in range(0,num):
            if a[i]&1 ==1:
                Sum += a[i]
                Del-= 1
            if Del ==0 : break
print(Sum)