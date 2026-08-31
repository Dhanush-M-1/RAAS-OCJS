from collections import defaultdict

def sol():
    T = int(input())
    for i in range(T):
        n, m = map(int, input().split(" "))
        letter = input()
        p = list(map(int, input().split(" ")))
        for i in range(len(p)):
            p[i] -= 1

        p.sort()

        count_list = [0] * n

        idx = n-1
        count = 0
        for i in range(m-1, -1, -1):
            while idx > p[i]:
                count_list[idx] = count
                idx -= 1
            count += 1

        for i in range(idx+1):
            count_list[i] = count

        count_by_char_dict = defaultdict(int)

        for i in range(n):
            count_by_char_dict[letter[i]] += (count_list[i] + 1)

        ans = [0] * 26
        for i in range(26):
            if chr(i + 97) in count_by_char_dict:
                ans[i] = count_by_char_dict[chr(i + 97)]

        for val in ans:
            print(val, end=' ')
        print()

if __name__ == '__main__':
    sol()