n = int(input())
first = input().split()
second = input().split()
third = input().split()
for i in range(n):
    first[i] = int(first[i])
    if i<n-1:
        second[i] = int(second[i])
    if i<n-2:
        third[i] = int(third[i])
first.sort()
second.sort()
third.sort()
a = -1
i = 0
while i<(n-1):
    if first[i] != second[i]:
        a = first[i]
        i = n+1
    i+=1
if a == -1:
    a = first[-1]
b = -1
j = 0
while j<(n-2):
    if third[j] != second[j]:
        b = second[j]
        j = n
    j+=1
if b == -1:
    b = second[-1]
print(a, b)



    
