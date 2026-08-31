# https://codeforces.com/contest/1374/problem/E1

def min_time(tot_books, books_like, read_time, a_time, b_time):
    time = []
    temp_a = []
    temp_b = []
    if min(sum(a_time), sum(b_time)) >= books_like:
        for x in range(tot_books):
            if a_time[x] == b_time[x] == 1:
                time.append(read_time[x])
            elif a_time[x] == 0 and b_time[x] == 1:
                temp_b.append(read_time[x])
            elif a_time[x] == 1 and b_time[x] == 0:
                temp_a.append(read_time[x])
        temp_a.sort(), temp_b.sort()
        for y in range(min(len(temp_a), len(temp_b))):
            time.append(temp_a[y] + temp_b[y])
        time.sort()
        time = time[:books_like]
        return sum(time)
    else:
        return -1
        # if len(time) > books_like:
        #     time = time[books_like - 1::-1]
        # elif len(time) < books_like:
        #     while len(time) != books_like:
        #         time.append(temp_a[0] + temp_b[0])
        #         del (temp_a[0], temp_b[0])
        #     time.sort(reverse=True)
        # else:
        #     time.sort(reverse=True)
        # y = 0
        # while y != (min(len(temp_a), len(temp_b))):
        #     if time[y] > temp_a[y] + temp_b[y]:
        #         time[y] = temp_a[y] + temp_b[y]
        #     else:
        #         break
        # y += 1


n, k = map(int, input().split())
t = []
a = []
b = []
for i in range(n):
    x, y, z = map(int, input().split())
    t.append(x), a.append(y), b.append(z)
print(min_time(n, k, t, a, b))
