#include <iostream>
using namespace std;
int n, m, a[55], b[55], c[55], d[55];
int main() {
	scanf("%d%d", &n, &m);
	for (int i = 1; i <= n; i++) scanf("%d%d", &a[i], &b[i]);
	for (int i = 1; i <= m; i++) scanf("%d%d", &c[i], &d[i]);
	for (int i = 1; i <= n; i++) {
		int e = -1;
		for (int j = 1; j <= m; j++) if (e == -1 || abs(a[i]-c[j])+abs(b[i]-d[j])<abs(a[i]-c[e])+abs(b[i]-d[e])) e=j;
		printf("%d\n", e);
	}
	return 0;	
}