book_number, like_num = map(int, input().split())
both_like = []
only_alice = []
only_bob = []

for _ in range(book_number):
    t, a, b = map(int, input().split())
    if a == b == 1:
        both_like.append(t)
    elif a == 1:
        only_alice.append(t)
    elif b == 1:
        only_bob.append(t)

i, j = 0, 0
time = 0
current_like = 0

both_like.sort()
only_alice.sort()
only_bob.sort()

while current_like < like_num:
    if i < len(both_like) and j < min(len(only_alice), len(only_bob)):
        if both_like[i] < only_alice[j] + only_bob[j]:
            time += both_like[i]
            i += 1
        else:
            time += (only_alice[j] + only_bob[j])
            j += 1
        current_like += 1

    elif i < len(both_like):
        time += both_like[i]
        i += 1
        current_like +=1

    elif j < min(len(only_alice), len(only_bob)):
        time += (only_alice[j] + only_bob[j])
        j += 1
        current_like += 1

    else:
        break

if current_like == like_num:
    print(time)
else:
    print(-1)
