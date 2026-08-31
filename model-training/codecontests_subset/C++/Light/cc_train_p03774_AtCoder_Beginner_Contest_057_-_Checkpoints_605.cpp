#include <bits/stdc++.h>

int main()
{
	int n, m, a[50], b[50], c[50], d[50];
	scanf("%d%d", &n, &m);
	for (int i = 0; i < n; i++) scanf("%d%d", a + i, b + i);
	for (int i = 0; i < m; i++) scanf("%d%d", c + i, d + i);
	for (int i = 0; i < n; i++)
	{
		int min_j{};
		for (int j = 1; j < m; j++)
		{
			if (std::abs(a[i] - c[j]) + std::abs(b[i] - d[j]) < std::abs(a[i] - c[min_j]) + std::abs(b[i] - d[min_j]))
				min_j = j;
		}
		printf("%d\n", min_j + 1);
	}

	return 0;
}