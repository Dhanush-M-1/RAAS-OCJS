_ = input()
s1 = sum(list(map(int, input().split())))
s2 = sum(list(map(int, input().split())))
s3 = sum(list(map(int, input().split())))

print(s1 - s2, s2 - s3, sep='\n')


