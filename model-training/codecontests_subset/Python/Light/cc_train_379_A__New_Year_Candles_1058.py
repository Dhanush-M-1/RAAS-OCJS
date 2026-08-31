def main():
    a, b = list(map(int, input().split()))
    light_out = 0
    total_time = 0
    while a > 0:
        total_time += 1
        a -= 1
        light_out += 1
        if light_out == b:
            light_out = 0
            a += 1
    print(total_time)


if __name__ == "__main__":
    main()
