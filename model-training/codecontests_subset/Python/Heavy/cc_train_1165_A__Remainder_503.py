def Input(n, x, y, Str):
    n, x, y = list(map(int, input().split()))
    Str = input()
    return n, x, y, Str

def Processing(n, x, y, Str):
    number_y = '1'
    number_result = ''
    for i in range(y):
        number_y = number_y + '0'
    while len(number_y) != x:
        number_y = '0' + number_y
    count = 0
    index_y = 0
    for index_Str in range(n - x, n):
        if Str[index_Str] != number_y[index_y]:
            count += 1
        index_y += 1
    print(count)

if __name__ == "__main__":
    n = 0
    x = 0
    y = 0
    Str = ''
    n, x, y, Str = Input(n, x, y, Str)
    Processing(n, x, y, Str)
