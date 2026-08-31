def op_rem_x_y(n, x, y, number):
    count_changes = 0
    for i in range(n-1, n-x-1, -1):
        if i >= n-y:
            if number[i] == '1':
                count_changes += 1
        elif i == n-y-1:
            if number[i] == '0':
                count_changes += 1
        else:
            if number[i] == '1':
                count_changes += 1
    return count_changes

def get_input(flag=0):
    if flag:
        return input()
    return [int(num) for num in input().split()]

if __name__ == '__main__':
    n, x, y = get_input()
    num = get_input(1)
    print(op_rem_x_y(n,x,y,num))