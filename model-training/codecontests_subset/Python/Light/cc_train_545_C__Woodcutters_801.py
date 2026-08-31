n=int(input())
l=[]
for num in range(n):
    string = input().split(' ')
    x,y =int(string[0]),int(string[1])
    l.append((x,y))
if n>1:
    count=2
else:
    count=1
space_occupied = ['left']
for num in range(1,len(l)-1):
    if l[num][0]-l[num-1][0]>l[num][1] and space_occupied[num-1]!='right':
        count+=1
        space_occupied.append('left')
    elif l[num][0]-l[num-1][0]>l[num][1]+l[num-1][1]:
        count+=1
        space_occupied.append('left')
    elif l[num+1][0]-l[num][0]>l[num][1]:
        count+=1
        space_occupied.append('right')
    else:
        space_occupied.append('None')
print(count)



