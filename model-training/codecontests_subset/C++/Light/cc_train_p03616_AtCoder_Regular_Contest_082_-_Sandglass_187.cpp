#include<iostream>
#include<algorithm>
using namespace std;

const int maxn = 100010;
int a[maxn];

int main()
{
	int i, j, X, K, Q;
	cin >> X >> K;
	for (i = 1; i <= K; i++)
		cin >> a[i];
	int L, R = X;
	int cnt = 0, k = 0, s = -1, x = 0, ans, num;
	int t, A;
	cin >> Q;
	for (i = 1; i <= Q; i++)
	{
		cin >> t >> A;
		while (k < K && a[k + 1] <= t)
		{
			ans = s * (a[k + 1] - cnt);
			L = max(0, min(X, L + ans));
			R = max(0, min(X, R + ans));
			cnt = a[k + 1];
			s = -s;
			x += ans;
			k++;
		}
		num = t - cnt;
		A = max(L, min(R, A + x));
		A = max(0, min(X, A + s * num));
		cout << A << endl;
	}
	return 0;
}