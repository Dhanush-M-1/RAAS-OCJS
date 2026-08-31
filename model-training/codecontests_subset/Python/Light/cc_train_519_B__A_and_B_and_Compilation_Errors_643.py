initial_errors = int(input())
fcerrors = list(map(int, input().split()))
scerrors = list(map(int, input().split()))
tcerrors = list(map(int, input().split()))

fcerrors.sort()
scerrors.sort()
tcerrors.sort()

j = 0
k = 0
l = 0

ans2 = -1
for i in range(0, len(scerrors) - 1):
	if scerrors[i] != tcerrors[i]:
		ans2 = scerrors[i]
		break

ans1 = -1
for i in range(0, len(fcerrors) - 1):
	if fcerrors[i] != scerrors[i]:
		ans1 = fcerrors[i]
		break

if ans1 == -1:
	print(fcerrors[len(fcerrors) - 1])
else:
	print(ans1)

if ans2 == -1:
	print(scerrors[len(scerrors) - 1])
else:
	print(ans2)