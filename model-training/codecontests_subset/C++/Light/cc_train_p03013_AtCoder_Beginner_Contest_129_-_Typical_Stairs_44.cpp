#include <cstdio>

int main ()
{
	int n, m, a[100005], in;
	scanf("%d %d", &n, &m);
	for (int i = 1; i <= n; i++)
		a[i] = -1;
	for (int i = 1; i <= m; i++)
	{
		scanf("%d", &in);
		a[in] = 0;
	}
	if (a[1] != 0)
		a[1] = 1;
	if (a[2] != 0)
		a[2] = 1 + a[1];
	for (int i = 3; i <= n; i++)
		if (a[i] == -1)
			a[i] = (a[i - 2] + a[i - 1]) % 1000000007;
	printf("%d", a[n]);
	return 0;
}