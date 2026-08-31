number = int(input())
arr = [int(x) for x in input().split()]
arr1 = [int(x) for x in input().split()]
arr2 = [int(x) for x in input().split()]
arr.sort()
arr1.sort()
arr2.sort()
ans1 =0
ans2 =0
i = 0
min2 =0
min1 =0
while ((ans1==0 or ans2==0) and i<number):
    #print("compare:"+str(arr[i])+str(arr1[i-min1])+str(arr2[i-min2]))
    c = arr[i]
    if(i-min2>=number-2): 
        c2=-1
    else: c2 = arr2[i-min2]
    if(i-min1>=number-1): 
        c1 = -1
    else: c1 = arr1[i-min1]
    if(c!=c2):
        if(c!=c1):
            ans1 = c
            min2+=1
            min1+=1
        else: 
            ans2 = c
            min2+=1
    i+=1
print(ans1)
print(ans2)