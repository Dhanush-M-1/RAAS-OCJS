import random
import threading

def merge(list):
	pos = len(list) * [0]
	res = []
	while True:
		idx = -1
		for i in range(len(list)):
			if pos[i] < len(list[i]) and (idx == -1 or list[i][pos[i]] < list[idx][pos[idx]]):
				idx = i
		if idx == -1:
			break
		res.append(list[idx][pos[idx]])
		pos[idx] += 1
	return res

class Thread(threading.Thread):
	def __init__(self, list):
		threading.Thread.__init__(self)
		self.list = list
	def run(self):
		self.list.sort()

def sort(A, N):
	q, r = len(A) // N, len(A) % N
	threads = []
	last = 0
	for i in range(N):
		n = q + int(i < r)
		threads.append(Thread(A[last : last + n]))
		last += n
	for thread in threads:
		thread.start()
	for thread in threads:
		thread.join()
	list = [thread.list for thread in threads]
	return merge(list)

if __name__ == '__main__':
	list = [int(x) for x in input().split('+')]
	list = sort(list, random.randint(1, len(list)))
	print('+'.join([str(x) for x in list]))