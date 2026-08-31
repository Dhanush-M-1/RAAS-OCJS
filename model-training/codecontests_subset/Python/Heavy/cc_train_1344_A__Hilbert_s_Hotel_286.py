def solve(arr, length):
    mod_arr = list(map(lambda x: x % length, arr))

    result = "YES"

    for idx1, value1 in enumerate(mod_arr):
        for idx2, value2 in enumerate(mod_arr):

            if idx1 == idx2:
                continue

            distance = (idx1 - idx2) % length
            difference = value2 - value1

            if distance == difference:
                result = "NO"
                break

        if result == "NO":
            break

    print(result)



if __name__ == '__main__':
    n = int(input())

    for i in range(n):
        length = int(input())
        arr_str = input().split(" ")
        arr = list(map(int, arr_str))
        solve(arr, length)
