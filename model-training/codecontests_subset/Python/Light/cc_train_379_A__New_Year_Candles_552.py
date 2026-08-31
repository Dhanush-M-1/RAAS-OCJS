
a = list(map(int, input().strip().split()))
t = a[0]
w = a[1]
ans  = t
while (t>=w):
    ans+=(t//w)
    t = (t//w) + (t % w)
print(ans)


    
