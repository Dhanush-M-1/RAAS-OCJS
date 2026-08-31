n = list(map(int, input().strip().split()))
h =0
p =n[0]
while(p!=0):
    h = h+1
    p = p-1
    if(h%n[1] == 0):
        p =p+1
print(h)

