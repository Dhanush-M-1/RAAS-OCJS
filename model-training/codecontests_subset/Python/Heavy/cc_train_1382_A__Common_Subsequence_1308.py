



test_cases = int(input())
answers = []
arr_ans = []
for _ in range(test_cases):
    n,m = [int(x) for x in input().split(' ')]
    arr1 = [int(x) for x in input().split(' ')]
    arr2 = [int(x) for x in input().split(' ')]
    arr2_set = set(arr2)

    #print(n,m)
    #print(arr1)
    #print(arr2)
    
    p1 = 0
    found = False
    while p1 < len(arr1):
        elem1 = arr1[p1]
        if elem1 in arr2_set:
            arr_ans.append(elem1)
            found = True
            answers.append("YES")
            break
        else:
            p1 +=1

    if not found:
        answers.append("NO")

p0 = 0
for ans in answers:
    
    print(ans)
    if ans == "YES":
        print(1,arr_ans[p0])
        p0 +=1
