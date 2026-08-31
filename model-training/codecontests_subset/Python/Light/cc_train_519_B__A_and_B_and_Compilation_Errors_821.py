n = int(input())

f = input()
s = input()
t = input()

f = f.split()
s = s.split()
t = t.split()

f = list(map(int,f))
s = list(map(int,s))
t = list(map(int,t))

sum1 = sum(f)
sum2 = sum(s)
sum3 = sum(t)

print(sum1-sum2)
print(sum2-sum3)
