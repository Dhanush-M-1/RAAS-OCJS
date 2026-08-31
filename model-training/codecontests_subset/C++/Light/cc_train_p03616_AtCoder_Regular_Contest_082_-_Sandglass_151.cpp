#include <algorithm>
#include <iostream>
#include <cstring>
#include <cstdio>
#include <cmath>
using namespace std;

inline int getint()
{
	static char c;
	while ((c = getchar()) < '0' || c > '9');

	int res = c - '0';
	while ((c = getchar()) >= '0' && c <= '9')
		res = res * 10 + c - '0';
	return res;
}

const int MaxM = 100000;
const int MaxN = 100000;

int x, m, n;
int rev[MaxM + 1];

int l, r, c;

inline void update(int delta)
{
	c += delta;

	if (l > x - c)
		l = r = x - c;
	else
		r = min(x - c, r);

	if (r < -c)
		l = r = -c;
	else
		l = max(l, -c);
}

int main()
{
	cin >> x >> m, r = x;
	for (int i = 1; i <= m; ++i)
		rev[i] = getint();

	cin >> n;

	int d = 0, k = 1, coef = -1;
	for (int i = 1; i <= n; ++i)
	{
		int t = getint(), a = getint();

		while (k <= m && rev[k] <= t)
		{
			update(coef * (rev[k] - d));
			d = rev[k++];
			coef = -coef;
		}
		update(coef * (t - d)), d = t;

		if (a <= l)
			printf("%d\n", l + c);
		else if (a <= r)
			printf("%d\n", a + c);
		else
			printf("%d\n", r + c);
	}

	return 0;
}