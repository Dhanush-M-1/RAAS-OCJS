n = int(input())

lst1 = input().split()
lst2 = input().split()
lst3 = input().split()

lst1.sort()
lst2.sort()
lst3.sort()

for i in range(n - 1):
    if lst1[i] != lst2[i]:
        print(lst1[i])
        break
else:
    print(lst1[n - 1])
    
for i in range(n - 2):
    if lst2[i] != lst3[i]:
        print(lst2[i])
        break
else:
    print(lst2[n - 2])