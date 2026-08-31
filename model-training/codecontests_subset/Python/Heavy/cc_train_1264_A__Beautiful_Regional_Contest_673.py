import math
for _ in range(int(input())):
    n = int(input())
    a = list(map(int,input().split()))
    cnt1,cnt2,cnt3 = 0,0,0

    req = n//2

    if req < 3:
        print(0 ,0,0)


    else:
        left = 0
        while (left< req and  a[left] == a[left+1]):
            cnt1 +=1
            left += 1

        cnt1 += 1
        left += 1

        right = n//2 -1
        while( right >= 0 and a[right] == a[right+1]):

            right -= 1

        cnt2 = cnt1+1

        i = cnt1 + left

        for i in range(cnt1+left,right+1):
            if a[i] != a[i+1]:
                break
            cnt2+= 1

        cnt3 = right - i

        if cnt1>= cnt2 or cnt1 >= cnt3:
            print(0,0,0)
        else:
            print(cnt1,cnt2,cnt3)
        
        

        
    

    

    


    
