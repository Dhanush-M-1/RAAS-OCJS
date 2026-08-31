

def get_result():
    n, k = input().split()
    n = int(n)
    k = int(k)

    r = input().split()
    for i, val in enumerate(r):
        r[i] = int(val)

    r.sort(reverse=True)

    for i in r:
        if k % i  == 0:
            return int(k/i)

if __name__ == "__main__":
    print(get_result())