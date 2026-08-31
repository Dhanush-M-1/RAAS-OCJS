#include <iostream>
#include <vector>

using namespace std;

void solve()
{
	int n;
	while(cin >> n, n)
	{
		vector<int> Vec(n);
		for(int i = 0; i < n; ++i)
		{
			cin >> Vec[i];
		}
		int count = 0;
		for(int i = 0; i < n; ++i)
		{
			for(int j = 0 ; j < n - i - 1; ++j)
			{
				if(Vec[j] > Vec[j + 1])
				{
					int temp = Vec[j];
					Vec[j] = Vec[j + 1];
					Vec[j + 1] = temp;
					++count;
				}
			}
		}
		cout << count << endl;
	}
}

int main()
{
	solve();
	return(0);
}