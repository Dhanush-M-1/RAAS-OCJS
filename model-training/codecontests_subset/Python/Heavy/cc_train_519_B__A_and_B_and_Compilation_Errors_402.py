"""
def binary_search(x,l,r,list):
    if l+1==r:
        if list[l]==x or list[r]==x:
            return True
        else:
            return False
    if l==r:
        if list[r]==x:
            return True
        else:
            return False
    else:
        middle=(l+r)//2
        if x<list[l]:
            return False
        elif x>list[r]:
            return False
        elif x==list[middle]:
            return True
        else:
            if x<list[middle]:
                return binary_search(x,l,middle-1,list)
            elif x>list[middle]:
                return binary_search(x,middle+1,r,list)

#pass sorted lists please
def diff_calculator(l1,l2):
    if len(l1)==2 and len(l2)==1:
        l1.remove(l2[0])
        return l1[0]
    else:
        if binary_search(l1[0],0,len(l2)-1,l2)==False:
            return l1[0]
        else:
            l1.pop(0)
            l2.pop(0)
            return diff_calculator(l1,l2)
"""
n=int(input())
l1=input().split(" ")
l2=input().split(" ")
l3=input().split(" ")
l1=list(map(int,l1))
l2=list(map(int,l2))
l3=list(map(int,l3))
print(sum(l1)-sum(l2))
print(sum(l2)-sum(l3))