N = int(input())
errors = [int(_) for _ in input().split()]
errors.sort()
for i in range(2):
    array = [int(_) for _ in input().split()]
    array.sort()
    k = N-(i+1)
    flag = 1
    for j in range(k):
        if errors[j]!=array[j]:
            flag = 0
            print(errors[j])
            break
    if flag==1:
        print(errors[-1])
    errors = array


