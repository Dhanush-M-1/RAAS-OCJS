s = input();
a = s.split();
n = int(a[0]);
k = int(a[1]);
s = input();
a = s.split();
for i in range(0, n):
    a[i] = int(a[i]);
a.sort();
for i in range(n - 1, -1, -1):
    if (k % a[i] == 0):
        print(int(k / a[i]));
        break;

