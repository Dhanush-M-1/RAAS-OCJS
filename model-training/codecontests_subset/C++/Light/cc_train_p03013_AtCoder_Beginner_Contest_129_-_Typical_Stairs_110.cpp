#include <cstdio>
const int P = 1000000007;
void add(int &x, int y)
{
	x = (x + y) % P;
}
int n, m, F[100005];
bool del[100005];
int main()
{
	scanf("%d%d", &n, &m);
	for (int i = 1, x; i <= m; ++i)
		scanf("%d", &x), del[x] = true;
	F[0] = 1;
	for (int i = 0; i <= n; ++i)
	{
		if (del[i]) F[i] = 0;
		add(F[i + 1], F[i]);
		add(F[i + 2], F[i]);
	}
	printf("%d\n", F[n]);
	return 0;
}
