number = int(input())
for i in range(number):
    a,b = input().split()
    array1 = input().split()
    array2 = input().split()
    result_str = "NO"
    result_val = 0;
    for j in range(int(a)):
        for k in range(int(b)):
            if array1[j] == array2[k]:
                result_str = "YES"
                result_val = array2[k]
                break
        else:
            continue
        break
    print(result_str)
    if result_str == "YES":
        print(f"{1} {result_val}")