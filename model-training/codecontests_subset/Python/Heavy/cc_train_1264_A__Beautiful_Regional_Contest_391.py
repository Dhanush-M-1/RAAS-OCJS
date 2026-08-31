def arr_float_inp():
    return [float(s) for s in input().split()]


def arr_int_inp():
    return [int(s) for s in input().split()]


def int_inp():
    return int(input())


def float_inp():
    return float(input())


if __name__ == '__main__':
    for _ in range(int_inp()):
        n = int_inp()
        inp_arr = arr_int_inp()
        arr = {}
        for i in range(n):
            if inp_arr[i] in arr:
                arr[inp_arr[i]] += 1
            else:
                arr[inp_arr[i]] = 1

        try:
            g, s, b = 0, 0, 0

            arr_values = list(arr.values())

            g = arr_values[0]

            id = 1
            while s <= g:
                s += arr_values[id]
                id += 1

            while b <= g or g + s + b + arr_values[id] <= n // 2:
                b += arr_values[id]
                id += 1
        except:
            print("0 0 0")
            continue

        if g + s + b > n // 2:
            print("0 0 0")
        else:
            print(str(g) + " " + str(s) + " " + str(b))
