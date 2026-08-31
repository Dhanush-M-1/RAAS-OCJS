n = int(input())
for i in range(n):
    m = input()
    lst1 = list(map(int,input().split()))
    lst2 = sorted(lst1)
    if lst2[0]+lst2[1]<=lst2[-1]:
        x = lst1.index(lst2[0])+1
        y = lst1.index(lst2[1])+1
        z = lst1.index(lst2[-1])+1
        if x==y:
            print(f"{x} {y+1} {z}")
        else:
            print(f"{x} {y} {z}")
    else:
        print(-1)
