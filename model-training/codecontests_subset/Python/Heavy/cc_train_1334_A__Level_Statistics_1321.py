tries  = int(input())

results = []
for trial in range(tries):
    times = int(input())
    result = "YES"

    last_max_x = 0
    last_max_p = 0

    for i in range(times):
        p, x = map(int, input().split())
        diff_p = p - last_max_p
        diff_x = x - last_max_x
        if result == "YES":
            if x > p or p < last_max_p or x < last_max_x or diff_x > diff_p:
                result = "NO"
        last_max_p = p
        last_max_x = x

    results.append(result)


for result in results:
    print(result)