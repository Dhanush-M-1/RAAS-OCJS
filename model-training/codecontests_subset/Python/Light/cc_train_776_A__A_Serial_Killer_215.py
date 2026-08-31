prvni, druhy = input().split()
N = int(input())
print(prvni, druhy)
for i in range(N):
    mrtvy, novy = input().split()
    if prvni == mrtvy:
        prvni = novy
    else:
        druhy = novy
    print(prvni, druhy)