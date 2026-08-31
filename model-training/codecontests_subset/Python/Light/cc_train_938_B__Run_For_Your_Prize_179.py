n=int(input())
prize_pos=list(input().split(' '))
me=1
friend=10**6
secs=0
found=0
right=n-1
left=0
for secs in range(int(friend/2)+1):
    if found==n and left>right:
        break
    elif str(me)==prize_pos[left] and str(friend)==prize_pos[right]:
        left+=1
        found+=2
        right-=1
    elif str(me)==prize_pos[left]:
         left+=1
         found+=1
    elif str(friend)==prize_pos[right]:
        right-=1
        found+=1
    me+=1
    friend-=1
print(secs-1)

