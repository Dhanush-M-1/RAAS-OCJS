n,k = [int(x) for x in input().split()]
lst = list(map(int,input().split()))
lst.sort(reverse=True)

while(len(lst)>=0):
    if(k%lst[0]==0):
        print(k//lst[0])
        break
    else:
        lst.pop(0)