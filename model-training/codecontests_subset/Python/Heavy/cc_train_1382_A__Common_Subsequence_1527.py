t=int(input())

def bin_search(l1,l, num):
    beg=0
    end=l
    while beg<=end:
        mid=(beg+end)//2
        if l1[mid]<num:
            beg=mid+1
        elif l1[mid]>num:
            end=mid-1
        else:
            return l1[mid]

    if num==l1[0]:
        return l1[0]
    
    return -1


while t:
    n,m=map(int, input().split())
    a=list(map(int, input().split()))
    b=list(map(int, input().split()))
    # print (a)

    for i in b:
        if i in a:
            print ("YES")
            print (1, i)
            break
    else:
        print ("NO")




    t=t-1