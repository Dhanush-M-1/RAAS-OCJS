
def f(n, arr):
    even = list(filter(lambda x: x % 2 == 0, arr))
    even.sort(reverse=True)
    odd = list(filter(lambda x: x % 2 == 1, arr))
    odd.sort(reverse=True)
    if len(even) - len(odd) > 1:
        return sum(even[len(odd) + 1:])
    elif len(odd) - len(even) > 1:
        return sum(odd[len(even) + 1:])
    else:
        return 0


# print(f"{f(5, [1, 5, 7, 8, 2])} = 0")
# print(f"{f(6, [5, 1, 2, 4, 6, 3])} = 0")
# print(f"{f(2, [1000000, 1000000])} = 1000000")
# print(f"{f(5, [1, 3, 5, 7, 9])} = 16")
# print(f"{f(5, [0, 2, 4, 6, 8])} = 12")
# print(f"{f(5, [1, 2, 4, 6, 8])} = 6")
# print(f"{f(5, [0, 3, 5, 7, 9])} = 8")
# print(f"{f(1, [10])} = 0")
# print(f"{f(1, [11])} = 0")
# print(f"{f(2, [10, 11])} = 0")

n = int(input())
arr = list(map(int, input().split()))
print(f(n, arr))
# 