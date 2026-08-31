for test_i in range(int(input())):
    n = int(input())
    arr = list(map(int, input().split()))
    max_el, min_el1 = max(arr), min(arr)
    max_eli, min_el1i = arr.index(max_el), arr.index(min_el1)
    arr[min_el1i] = max_el + 1
    min_el2 = min(arr)
    min_el2i = arr.index(min_el2)
    ans = [max_eli + 1, min_el1i + 1, min_el2i + 1]
    ans.sort()
    print(' '.join(list(map(str, ans))) if min_el1 + min_el2 <= max_el else -1)