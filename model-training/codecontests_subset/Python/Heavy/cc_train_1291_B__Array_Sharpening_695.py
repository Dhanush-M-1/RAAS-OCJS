for ti in range(int(input())):
    nd = int(input())
    a = [int(x) for x in input().split()]
    desc = False
    for ai in range(len(a)):
        if(not desc):
            if(a[ai] < ai):
                desc = True
            else:
                a[ai] = max(ai, a[ai])
        if(desc):
            if(a[ai] < len(a) - ai - 1):
                print("No")
                break
            else:
                a[ai] = len(a) - ai - 1
                if(a[ai] >= a[ai-1]):
                    print("No")
                    break
    else:
        print("Yes")        
