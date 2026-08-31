#include <iostream>

using namespace std;

const int p = 1000000007;
int n, m, f[100005];
bool bad[100005];

int main()
{
	cin >> n >> m;
	for (int i = 1; i <= m; i++)
	{
		int a;
		cin >> a;
		bad[a] = 1;
	}
	f[0] = 1;
	f[1] = 1;
	for (int i = 2; i <= n; i++)
	{
		if (!bad[i - 2]) f[i] += f[i - 2];
		if (!bad[i - 1]) f[i] += f[i - 1];
		f[i] %= p;
	}
	cout << f[n] << endl;
	return 0;
 } 