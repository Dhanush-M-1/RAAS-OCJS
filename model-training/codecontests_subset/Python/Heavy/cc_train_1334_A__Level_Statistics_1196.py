t = int(input())
for i in range(t):
    n = int(input())
    lst1 = []
    lst2 = []
    for j in range(n):
        a,b = input().split()
        a = int(a)
        b = int(b)
        lst1.append(a)
        lst2.append(b)
    count = 0
    if lst2[0] > lst1[0]:
        print("NO")
    else:
        count +=1
        for j in range(1,n):
            if lst1[j] < lst1[j-1]:
                print("NO")
                break
            elif lst2[j] < lst2[j-1]:
                print("NO")
                break
            elif lst1[j] == lst1[j-1] and lst2[j] > lst2[j-1]:
                print("NO")
                break
            else:
                if lst1[j] > lst1[j-1] and lst2[j] > lst2[j-1]:
                    x = lst1[j] - lst1[j-1]
                    y = lst2[j] - lst2[j-1]
                    if y > x:
                        print("NO")
                        break
                    else:
                        count+=1
                else:
                    count +=1
    if count == n:
        print("YES")