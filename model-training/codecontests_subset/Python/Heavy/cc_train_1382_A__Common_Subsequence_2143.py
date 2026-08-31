def solution(arr1, arr2):
    res = 'No'
    for e1 in arr1:
        if res != 'No':
            break
        for e2 in arr2:
            if e1 == e2:
                res = 'Yes\n1 ' + str(e1)
                break
    return res


def main():
    for test in range(int(input())):
        _, _ = map(int, input().split())
        arr1 = list(map(int, input().split()))
        arr2 = list(map(int, input().split()))
        result = solution(arr1, arr2)
        print(result)


if __name__ == '__main__':
    main()
