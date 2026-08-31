# A. Плохой треугольник

t = int(input())
arrays = []
for i in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    arrays.append(a)


def func(arr: list):
    if arr[0] + arr[1] > arr[len(arr) - 1]:
        print(-1)
        return
    else:
        print(f'1 2 {len(arr)}')
        return

    # for i in range(len(arr)):
    #     for j in range(i + 1, len(arr)):
    #         sum = arr[i] + arr[j]
    #         for k in range(len(arr) - 1, j, -1):
    #             if sum <= arr[k]:
    #                 print(f'{i + 1} {j + 1} {k + 1}')
    #                 return
    # print(-1)


for arr in arrays:
    func(arr)