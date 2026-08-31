def check_diff(l1,l2):
    for i in range(len(l1)):
        if i > len(l2)-1:
            print(l1[i])
            break
        elif l1[i] != l2[i]:
            print(l1[i])
            break
            

n = int(input())
l1 = list(map(int, input().split()))
l2 = list(map(int, input().split()))
l3 = list(map(int, input().split()))     

l1.sort()
l2.sort()
l3.sort()
check_diff(l1,l2)
check_diff(l2,l3)