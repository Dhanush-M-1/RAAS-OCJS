a,b=list(map(int,input().split()))
array=list(map(int,input().split()))
c=b-1
answer=[]
array.sort()
arr=list(range(1,array[-1]+1))
for it in arr:
    element=it
    current=0
    count=0
    for y in range(0,a):
        copare=array[y]
        if copare<element:
            pass
        elif current==b:
            answer.append(count)
            break
        else:
            moves=0
            flag=5
            while True:
                if copare==element:
                    break
                elif copare<element:
                    flag=6
                    break
                else:
                    copare=int(copare//2)
                    moves+=1
            if flag==6:
                pass
            else:
                count+=moves
                current+=1
    if current==b:
        answer.append(count)
array=array[0:b]
moves=0
for it in array:
    while True:
        if it==0:
            break
        else:
            it=int(it//2)
            moves+=1
answer.append(moves)
print(min(answer))
                