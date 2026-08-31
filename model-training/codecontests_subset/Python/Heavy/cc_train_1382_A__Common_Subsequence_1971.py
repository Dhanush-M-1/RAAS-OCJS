#common subsequence
def commonsubsequence(l1,l2,l3):
    c = list()
    for i in  l2:
        if i in l3:
            c.append(i)
            break
    if len(c) == 0:
        print("No ")
    else:
        print("Yes ")
        print(len(c),end=" ")
        for i in c:
            print(i,end = " ")
        print()
 
 
t = int(input())
while t>0 :
    l1 = list(map(int,input().split()))
    l2 = list(map(int,input().split()))
    l3 = list(map(int,input().split()))
    commonsubsequence(l1,l2,l3)
    t-=1