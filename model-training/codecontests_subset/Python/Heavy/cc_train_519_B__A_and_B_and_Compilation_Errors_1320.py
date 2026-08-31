is_debug = False

n = int(input())

s1 = sorted([int(x) for x in input().split()])
s2 = sorted([int(x) for x in input().split()])
s3 = sorted([int(x) for x in input().split()])

print(f's1={s1}') if is_debug else ''
print(f's2={s2}') if is_debug else ''
print(f's3={s3}') if is_debug else ''

found = False
for i in range(0, len(s2)):
  if s1[i] != s2[i]:
    print(f'{s1[i]}')
    found = True
    break

if not found:
  print(f'{s1[len(s1)-1]}')

found = False
for i in range(0, len(s3)):
  if s2[i] != s3[i]:
    print(f'{s2[i]}')
    found = True
    break

if not found:
  print(f'{s2[len(s2)-1]}')
