n = int(input())
nums = list(map(int, input().split()))
odds = [num for num in nums if num % 2 == 1]
evens = [num for num in nums if num % 2 == 0]
odds.sort(reverse=True)
evens.sort(reverse=True)

## mode1: begin with even
delete_even_cnt = min(len(evens), len(odds) + 1)
delete_odd_cnt = min(len(odds), delete_even_cnt)
ans1 = sum(odds[delete_odd_cnt:]) + sum(evens[delete_even_cnt:])

## mode2: begin with odd
delete_odd_cnt = min(len(odds), len(evens) + 1)
delete_even_cnt = min(len(evens), delete_odd_cnt)
ans2 =  sum(odds[delete_odd_cnt:]) + sum(evens[delete_even_cnt:])
ans = min(ans1, ans2)
print(ans)
