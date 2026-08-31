while True:
    try:
        n = eval(input().strip())
        str = input().strip()
        counter = 0
        for i in str:
            if i == '8':
                counter += 1

        size = len(str)
        ans = 0
        for i in range(1,counter + 1):
            sum = int(10) * int(i)
            sum += int(i)
            if size >= sum:
                ans = max(ans,i)
            else:
                break

        print(ans)
    except:
        break