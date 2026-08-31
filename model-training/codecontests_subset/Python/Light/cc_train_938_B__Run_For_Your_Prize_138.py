#s = input ().split () —> string input;
#x = list (map (int, input ().split()));
# python3 asd.py
#s = s.replace(s[0], 'b');

n = int (input ());
x = list (map (int, input().split()));

mx = int (1000000);

men = [];
dostum = [];

x.sort ();

for i in range (n):
	men.append (x[i] - 1);
	dostum.append (mx - x[i]);

ans = 0;
for i in range (n):
	q = min (men[i], dostum[i]);
	if q > ans: ans = q;

print (ans);
