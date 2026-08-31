def main():
    [__, l] = [int(_) for _ in input().split()]
    buckets = [int(_) for _ in input().split()]
    buckets = [b for b in buckets if b <= l]
    buckets.sort(reverse=True)

    result = next((l // bucket) for bucket in buckets if l % bucket == 0)
    print(result)


if __name__ == '__main__':
    main()
