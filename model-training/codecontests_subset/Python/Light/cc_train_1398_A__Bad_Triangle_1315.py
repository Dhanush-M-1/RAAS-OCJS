

if __name__ == "__main__":
    # Happens num times
    num_cases = int(input())
    for i in range(num_cases):
        # Do loop calling length and integers, num times
        length = int(input())
        integers = list(map(int, input().split()))
        if integers[0] + integers[1] > integers[-1]:
            print(-1)
        else:
            print(1, 2, length)
