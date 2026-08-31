password = input()
n = int(input())
tries = [input() for _ in range(n)]


def get_result():
    for t in tries:
        if t == password:
            return True
        for i in range(n):
            if (t[1] + tries[i][0]) == password or (tries[i][1] + t[0]) == password:
                return True
    return False


print('YES' if get_result() else 'NO')
