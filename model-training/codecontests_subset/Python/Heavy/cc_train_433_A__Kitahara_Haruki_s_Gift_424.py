num_apple=int(input())
weight=input().split()
if num_apple!=1:
    count1=0
    count2=0
    i=0
    while i<len(weight):
        if '100' == weight[i]:
            count1+=1
        i+=1
    j=0
    while j<len(weight):
        if '200' == weight[j]:
            count2+=1
        j+=1
    if count1%2==0 and count2%2==0:
        print("YES")
    elif count1%2!=0 and count2%2!=0:
        print("NO")
    elif count1%2!=0 and count2%2==0:
        print("NO")
    elif count1%2==0 and count2%2!=0:
        if count1==0 and count2%2!=0:
            print("NO")
        else:
            print("YES")
else:
    print("NO")
