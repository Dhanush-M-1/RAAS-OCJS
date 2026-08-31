total, a,b,c = map(int, input().split())
total*=2
sols=0

def twosnfours(target, x,y):
    if target%4==2:
        x-=1
        target-=2
    if x<0:
        return 0
    count=0
    fours=target//4
    for j in range(fours,-1,-1):
        if y >= j:
            if x >= (target-4*j)//2:
                count += 1
    return count


if total%1 != 0:
    total-=1
    a-=1
    sols+=1
if total%2 != 0:
    total-=2
    sols+=1
    b-=1
if a<0 or b<0:
    print("0")
    quit()

for i in range(0,a+1,2):
    left=total-i
    if left < 0: break
    if left==0:
        sols+=1
        break
    sols += twosnfours(left,b,c)

print(sols)