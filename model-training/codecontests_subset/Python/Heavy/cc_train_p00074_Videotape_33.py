default = 120 * 60

while 1:
    t, h, s = map(int, input().split())
    if t == -1 and h == -1 and s == -1:
        break

    time = t * 3600 + h * 60 + s
    diff = default - time
    diff3 = diff * 3

    diff_t = str(diff // 3600).zfill(2)
    diff_h = str(diff % 3600 // 60).zfill(2)
    diff_s = str(diff % 60).zfill(2)

    diff_3t = str(diff3 // 3600).zfill(2)
    diff_3h = str(diff3 % 3600 // 60).zfill(2)
    diff_3s = str(diff3 % 60).zfill(2)

    print(diff_t + ":" + diff_h + ":" + diff_s)
    print(diff_3t + ":" + diff_3h + ":" + diff_3s)

