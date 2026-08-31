#include <iostream>
#include <vector>
#include <string>

using namespace std;
int tanku[] = {5, 7, 5, 7, 7};

void solve()
{
	int n;
	while (cin >> n, n)
	{
		vector<int> w(n);
		for (int i = 0; i < n; ++i)
		{
			string s;
			cin >> s;
			w[i] = s.size();
		}
		for (int i = 0; i < n; ++i)
		{
			int pos = 0;
			int cnt = 0;
			for (int j = i; j < n; ++j)
			{
				cnt += w[j];
				if (cnt == tanku[pos])
				{
					++pos;
					cnt = 0;
				}
				if (pos >= 5 || cnt > tanku[pos])
				{
					break;
				}
			}
			if (pos == 5)
			{
				cout << i + 1 << endl;
				break;
			}
		}
	}
}

int main()
{
	solve();
	return(0);
}