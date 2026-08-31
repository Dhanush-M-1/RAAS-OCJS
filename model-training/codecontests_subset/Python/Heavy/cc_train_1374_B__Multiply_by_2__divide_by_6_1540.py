from sys import stdin, stdout

t = int(stdin.readline().strip())

for _ in range(t):
    n = int(stdin.readline().strip())
    if n == 1:
        stdout.write('0\n')
    else:
        answer, times = 0, 0
        while n != 1:
            if n % 6 == 0:
                n //= 6
                answer += 1
            else:
                n *= 2
                times += 1
                answer += 1
            if times > 128 or n % 3 != 0 and n != 1:
                answer = -1
                break
        stdout.write(str(answer) + '\n')
