import math
def divisors(number):
    l = []
    for x in range(2, int(math.sqrt(number))):
        if number % x == 0:
            l.append(x)
    l.append(number)
    return l

read = input().split()
l = int(read[0])
r = int(read[1])
div_count = {'max': '2', 'max_count': 0}
if (len(range(l, r+1)) < 3):
    for number in range(l, r+1):
        for div in divisors(number):
            key = str(div)
            if key in div_count:
                div_count[key] += 1
            else:
                div_count[key] = 1
                if div_count[key] > div_count['max_count']:
                    div_count['max'] = key
                    div_count['max_count'] = div_count[key]

print(div_count['max'])