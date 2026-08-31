N = int(input())
for i in range(N):
    Data = list(map(int, input().split()))
    n = Data[2]
    if n < 2:
        print(Data[n])
    else:
        ans = ""
        num_a = str(bin(Data[0]))
        num_a = num_a[2:]
        num_b = str(bin(Data[1]))
        num_b = num_b[2:]
        M = max(len(num_a), len(num_b))
        for j in range(0, M):
            pa = len(num_a) - j - 1
            pb = len(num_b) - j - 1
            if pa < 0 or num_a[pa] == '0':
                if pb < 0 or num_b[pb] == '0':
                        ans += '0'
                else:
                    if n % 3 == 2 or n % 3 == 1:
                        ans += '1'
                    else:
                        ans += '0'
            if pa >= 0 and num_a[pa] == '1':
                if pb < 0 or num_b[pb] == '0':
                    if n % 3 == 2 or n % 3 == 0:
                        ans += '1'
                    else:
                        ans += '0'
                else:
                    if n % 3 == 0 or n % 3 == 1:
                        ans += '1'
                    else:
                        ans += '0'

        tmp_ans = ""
        for i in range(len(ans)-1, -1, -1):
            tmp_ans += ans[i]
        tmp_ans = int(tmp_ans, 2)
        print(tmp_ans)



