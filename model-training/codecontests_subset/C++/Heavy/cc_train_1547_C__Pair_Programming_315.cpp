#include<bits/stdc++.h>
using namespace std;
int n, m, k;
int a[310], b[310];

int main() {
	int t;
	scanf("%d", &t);
	getchar();
	while (t--) {
		queue<int> q;
		scanf("%d %d %d", &k, &n, &m);
		for (int i = 1; i <= n; i++)
			scanf("%d", &a[i]);
		for (int i = 1; i <= m; i++)
			scanf("%d", &b[i]);

		int i = 1, j = 1;
		bool st = true;
		while (i + j != n + m + 2) {
			if (i <= n && a[i] == 0) {
				q.push(0);
				i++;
				k++;
				continue;
			}
			if (j <= m && b[j] == 0) {
				q.push(0);
				j++;
				k++;
				continue;
			}
			if (i <= n && a[i] <= k) {
				q.push(a[i]);
				i++;
				continue;
			}
			if (j <= m && b[j] <= k) {
				q.push(b[j]);
				j++;
				continue;
			}
			st = false;
			break;
		}
		if (st) {
			while (!q.empty()) {
				int t = q.front();
				q.pop();
				printf("%d ", t);
			}
			printf("\n");
		} else
			printf("-1\n");
	}
	return 0;
}