a , b = map(int, input().split())

count = 0
burned = 0 
while(a > 0):
    count += 1
    burned += 1

    if(burned % b == 0):
        burned = 0
    else:
        a -= 1

print(count)