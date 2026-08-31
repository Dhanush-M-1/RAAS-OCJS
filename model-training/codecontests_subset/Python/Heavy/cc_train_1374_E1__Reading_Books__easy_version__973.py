n, k = map(int, input().strip().split())

not_possible = False

alice_only, bob_only, both = [], [], []
alice_likes, bob_likes = 0, 0
total_time = 0
for _ in range(n):
    t, alice, bob = map(int, input().strip().split())
    alice_likes += alice
    bob_likes += bob
    if alice + bob == 2:
        both.append(t)
    elif alice:
        alice_only.append(t)
    elif bob:
        bob_only.append(t)

    if alice + bob > 0:
        total_time += t

if alice_likes < k or bob_likes < k:
    not_possible = True

alice_remove = alice_likes - k
bob_remove = bob_likes - k

both_remove = min(alice_remove, bob_remove)
alice_remove -= both_remove
bob_remove -= both_remove

both.sort(reverse=True)
alice_only.sort(reverse=True)
bob_only.sort(reverse=True)

a, b = 0, 0
while a < len(alice_only) and alice_remove > 0:
    total_time -= alice_only[a]
    a += 1
    alice_remove -= 1

while b < len(bob_only) and bob_remove > 0:
    total_time -= bob_only[b]
    b += 1
    bob_remove -= 1

alice_only = alice_only[a:]
bob_only = bob_only[b:]

ab, o = 0, 0
while both_remove > 0:
    curr_ab, curr_both = 0, 0
    if ab < len(alice_only) and ab < len(bob_only):
        curr_ab = alice_only[ab] + bob_only[ab]
    if o < len(both):
        curr_both = both[o]
    
    if curr_ab + curr_both == 0:
        break

    if curr_ab > curr_both:
        total_time -= curr_ab
        ab += 1
    else:
        total_time -= curr_both
        o += 1

    both_remove -= 1

alice_remove += both_remove
bob_remove += both_remove

a, b = ab, ab
while a < len(alice_only) and alice_remove > 0:
    total_time -= alice_only[a]
    a += 1
    alice_remove -= 1

while b < len(bob_only) and bob_remove > 0:
    total_time -= bob_only[b]
    b += 1
    bob_remove -= 1

if not_possible:
    print(-1)
else:
    print(total_time)