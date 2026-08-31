#include <iostream>
#include <vector>

using namespace std;

void solve()
{
	int n;
	while(cin >>n, n)
	{
		vector<int> Vec(n);
		for(int i = 0; i < n; ++i)
		{
			cin >> Vec[i];
		}
		int count = 0;
		for(int i = 0; i < n - 1; ++i)
		{
			for(int j = n - 1; j > i; --j)
			{
				if(Vec[j - 1] > Vec[j])
				{
					int temp = Vec[j];
					Vec[j] = Vec[j - 1];
					Vec[j - 1] = temp;
					count++;
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