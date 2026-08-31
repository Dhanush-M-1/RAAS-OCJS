def get_x(p, w, d):
    x = p // w   # start from upper bound of x
    q_list = [False] * d

    while x >= 0:
        q = (p - x * w) % d
        if q == 0: break        # found integer y
        if q_list[q]: x = -1    # reached cycle
        q_list[q] = True        # marked as visited
        x -= 1                  # decrement x and try again

    return x


def main():
    raw_in = input()
    npwd = [int(x) for x in raw_in.split(' ')]
    
    x = get_x(npwd[1], npwd[2], npwd[3])

    if x < 0:
        print("-1")
        return

    y = (npwd[1] - x * npwd[2]) // npwd[3]
    z = npwd[0] - x - y

    if y < 0 or z < 0:
        print("-1")
        return

    print("{} {} {}".format(x, y, z))

if __name__ == "__main__":
    main()

