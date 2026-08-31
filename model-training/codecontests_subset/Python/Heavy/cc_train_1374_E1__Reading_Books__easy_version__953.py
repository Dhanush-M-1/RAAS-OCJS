n , k = map(int,input().split(" "))
arr_a = []
arr_b = []
arr_c = []
cnt1=0
cnt2=0
for i in range (0,n):
    t, a, b = map(int,input().split(" "))
    if a ==1 and b==1 :
        cnt1+=1
        cnt2+=1
        arr_c.append(t)
    elif a==1 and b==0 :
        cnt1+=1
        arr_a.append(t)
    elif a==0 and b==1 :
        cnt2+=1
        arr_b.append(t)

if (cnt1<k) or (cnt2 < k) :
    print(-1)
else:
    arr_a.sort()
    arr_b.sort()
    arr_c.sort() 
    cnt = 0
    ans=0
    x=0
    y=0
    z=0
    while cnt < k:
        if x >= len(arr_c):
            cnt+=1
            ans+= arr_a[y]+arr_b[z]
            y+=1
            z+=1
        
        elif y>= len(arr_a) or z>= len(arr_b):
            cnt+=1
            ans+= arr_c[x]
            x+=1

        elif arr_c[x]< arr_a[y]+arr_b[z]:
            cnt+=1
            ans+= arr_c[x]
            x+=1
        
        else:
            cnt+=1
            ans+= arr_a[y]+arr_b[z]
            y+=1
            z+=1
    print(ans)









    
        
    
    