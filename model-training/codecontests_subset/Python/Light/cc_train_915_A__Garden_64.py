# Uses python3


def solution(k, buckets):
    if k <= 0:
        return 0

    max_bucket = 1
    for bucket in buckets:
        if k % bucket == 0 and bucket > max_bucket:
            max_bucket = bucket

    return k // max_bucket


if __name__ == '__main__':
    f = [int(x) for x in input().split()]
    n, k = f[0], f[1]
    buckets = [int(x) for x in input().split()]
    print(solution(k, buckets))
