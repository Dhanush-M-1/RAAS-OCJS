#include <iostream>
#include <cstdio>
#define N 100005
using namespace std;

int M = 1e9 + 7;
int n, m, d[N] = {0, 1};
bool v[N];
int main()
{
	int i, t;
	cin >> n >> m;
	while (m--) scanf("%d", &t), v[t + 1] = 1;
	for (i = 2; i <= n + 1; i++) {
		if (!v[i]) d[i] = (d[i - 1] + d[i - 2]) % M;
	}
    cout << d[n + 1] << endl;
    return 0;
}