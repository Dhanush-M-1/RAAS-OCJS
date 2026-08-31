def first(set1, set2,n):
    for i in range(n-1):
        if(set1[i]!=set2[i]):
            return set1[i]
    return set1[-1]

n = int(input())
set1 = [int(x) for x in input().split()]
set2 = [int(x) for x in input().split()]
set3 = [int(x) for x in input().split()]
set1.sort()
set2.sort()
set3.sort()
a = first(set1,set2,n)
b = first(set2,set3, n-1)

print(a)
print(b)