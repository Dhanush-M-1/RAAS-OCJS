n = int(input())
first = list(sorted(list(map(int, input().split()))))
second = list(sorted(list(map(int, input().split()))))
third = list(sorted(list(map(int, input().split()))))
i = 0
while(i < n-1 and second[i]==first[i]):
    i+=1

print(first[i])
i = 0
while(i < n-2 and second[i]==third[i]):
    i+=1
print(second[i])