from sys import stdin, exit
input = stdin.readline

def i(): return input()
def ii(): return int(input())
def iis(): return map(int, input().split())
def liis():	return list(map(int, input().split()))
def print_array(a): print(" ".join(map(str, a)))

n, k = iis()
alice = []
bob = []
both = []
for _ in range(n):
	t, a, b = iis()
	if a == 1 and b == 0:
		alice.append(t)
	elif a == 0 and b == 1:
		bob.append(t)
	elif a == 1 and b == 1:
		both.append(t)
alice = sorted(alice)[::-1]
bob = sorted(bob)[::-1]
both = sorted(both)[::-1]

time = 0
livros = 0
while k > 0 and (len(both) != 0 or (len(alice) != 0 and len(bob) != 0)):
	if len(both) and len(alice) and len(bob):
		separado = alice[-1]+bob[-1]
		junto = both[-1]
		if junto < separado:
			time += junto
			both.pop()
		else:
			time += separado
			alice.pop()
			bob.pop()
	elif len(both):
		time += both.pop()
	elif len(alice) and len(bob):
		time += alice.pop()
		time += bob.pop()
	else:
		continue
	k -= 1

if k == 0:
	print(time)
else:
	print(-1)
