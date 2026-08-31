n = int(input())
s = input()
eight_cnt = s.count('8')
cnt = len(s) // 11
print(cnt if cnt < eight_cnt else eight_cnt)
