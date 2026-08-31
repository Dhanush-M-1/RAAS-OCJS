#include <iostream>
#include <set>

using namespace std;

void solve()
{
	int Q;
	cin >> Q;
	while(Q--)
	{
		int N;
		cin >> N;
		int count = 0;
		set<int> isExist;
		while(true)
		{
			if(N < 10)
			{
				cout << count << endl;
				break;
			}
			int digit = 0;
			int NBuf = N;
			while(NBuf)
			{
				NBuf /= 10;
				++digit;
			}
			int max = 0;
			int a = 10;
			for(int i = 1; i < digit; ++i)
			{
				int left = N / a;
				int right = N % a;
				if(left * right > max)
				{
					max = left * right;
				}
				a *= 10;
			}
			if(isExist.find(max) == isExist.end())
			{
				isExist.insert(max);
			}
			else
			{
				cout << -1 << endl;
				break;
			}
			N = max;
			++count;
		}
	}
}

int main()
{
	solve();
	return(0);
}