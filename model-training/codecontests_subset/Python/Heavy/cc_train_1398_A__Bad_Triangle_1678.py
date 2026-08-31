t=int(input())
for _ in range(t):
    n=int(input())
    a=list(map(lambda x: int(x), input().split()))
    minimum=a[0]
    minimum_index=0
    for i in range(1,len(a)):
        if a[i]<minimum:
            minimum=a[i]
            minimum_index=i
    second_minimum=a[0] if 0!=minimum_index else a[1]
    second_minimum_index=0 if 0!=minimum_index else 1

    for i in range(0,len(a)):
        if a[i]<second_minimum and i!=minimum_index:
            second_minimum=a[i]
            second_minimum_index=i
    maximum = a[0]
    maximum_index = 0


    for i in range(0, len(a)):
        if a[i] > maximum :
            maximum = a[i]
            maximum_index = i

    if minimum+second_minimum<=maximum:
        a=[maximum_index,second_minimum_index,minimum_index]
        a.sort()
        print(a[0]+1,a[1]+1,a[2]+1)
    else:
        print(-1)
