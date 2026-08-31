#include <iostream>
#include <vector>
#include <cstring>


using namespace std;
#define rep(i, n) for(int i = 0; i < int(n); i++)

int BIT[1000001];

int sum(int idx)
{
	int ret = 0;
	while (idx > 0)
	{
		ret += BIT[idx];
		idx -= idx & -idx;
	}
	return ret;
}

const int N = 1000000;
void add(int idx, int num)
{
	while (idx <= N)
	{
		BIT[idx] += num;
		idx += idx & -idx;
	}
}

signed main()
{
	int n;
	while (cin >> n && n)
	{
		memset(BIT, 0, sizeof(BIT));
		int ans = 0;
		vector<int> arr(n);
		rep(i, n) cin >> arr[i];
		rep(i, n)
		{
			ans += i - sum(arr[i]);
			add(arr[i], 1);
		}
		cout << ans << endl;
	}
	return 0;
}