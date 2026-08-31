n=int(input())
lst1=list(int(num) for num in input().split())[:n]
lst2=list(int(num) for num in input().split())[:n-1]
lst3=list(int(num) for num in input().split())[:n-2]

print(sum(lst1)-sum(lst2))
print(sum(lst2)-sum(lst3))

