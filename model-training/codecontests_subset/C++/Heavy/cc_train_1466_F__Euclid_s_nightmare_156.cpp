#include <cstdio>
#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;

const int N = 500000;
const long long modd = 1000000007;

int n, m;
int kk;
int aa[N + 5];
long long anss[N + 5], co = 0;
int ff[N + 5];
struct ab
{
	int u;
	int v;
} ee[N + 5];

long long qpow(long long a, long long b)
{
	long long c = 1;
	while (b)
	{
		if (b & 1)
		{
			c = c * a % modd;
		}
		a = a * a % modd;
		b >>= 1;
	}
	return c;
}

int find(int x)
{
	if (ff[x] != x)
	{
		return ff[x] = find(ff[x]);
	}
	return x;
}

int main()
{
	scanf("%d%d", &n, &m);
	for (int i = 1; i <= n; ++i)
	{
		scanf("%d", &kk);
		ee[i].v = m + 1;
		if (kk == 1)
		{
			scanf("%d", &ee[i].u);
		}
		else
		{
			scanf("%d%d", &ee[i].u, &ee[i].v);
		}
	}
	for (int i = 1; i <= m + 1; ++i)
	{
		ff[i] = i;
	}
	for (int i = 1; i <= n; ++i)
	{
		int a = find(ee[i].u);
		int b = find(ee[i].v);;
		if (a != b)
		{
			ff[a] = b;
			anss[++co] = i;;
		}
	}
	printf("%lld %lld\n", qpow(2, co), co);
	for (int i = 1; i <= co; ++i)
	{
		printf("%lld ", anss[i]);;
	}
	return 0;;
}