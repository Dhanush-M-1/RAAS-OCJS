import datetime
def count_time(func):
	def int_time(*args, **kwargs):
		print('*' * 10,'Code start running!')
		start_time = datetime.datetime.now()  # 程序开始时间
		func()
		over_time = datetime.datetime.now()   # 程序结束时间
		total_time = (over_time-start_time).total_seconds()
		print('*' * 10, 'Total time: %s' % total_time)
	return int_time

def gcd(a,b):
    if a%b == 0:
        return b
    else :
        return gcd(b,a%b)

def count(max_num, num):
	gcd_num = max_num - num[0]
	ans = 0
	for i in num:
		dif = max_num - i
		if dif == 0:
			continue
		gcd_num = gcd(gcd_num, dif)
	for i in num:
		ans += (max_num - i) // gcd_num
	return (max_num, ans, gcd_num)
			

#@count_time		
def main():
	while True:
		try:
			T = int(input().strip())
			num = list(map(int, input().strip().split()))
			max_num = max(num)
			currect = count(max_num, num)
#for i in (max_num, max_num * max_num):
#				currect = count(i, num)
#				ans = min(ans, currect[0])
			print(currect[1], currect[2])
		except EOFError:
			break

if __name__ == '__main__':
	main()
